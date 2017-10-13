package com.example.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Inventario;
import com.example.model.ItemInventario;
import com.example.model.Relatorio;
import com.example.model.Sobrevivente;
import com.example.repository.ItemInventarioRepository;
import com.example.repository.SobreviventeRepository;

@Service 
public class SobreviventeService {

	@Autowired 
	private SobreviventeRepository repository; 

	@Autowired
	private ItemInventarioRepository inventarioRepository;
	
	/**
	 * Função para salvar os dados do sobrevivente e seu inventário.
	 * @param sobrevivente
	 * @return TRUE no término do método.
	 */
	public Boolean salvar(Sobrevivente sobrevivente) {

		sobrevivente.getInventario().setSobrevivente(sobrevivente);

		sobrevivente.getInventario().getItens().forEach(itemInventario -> { 
			
			itemInventario.setInventario(sobrevivente.getInventario());

		});

		this.repository.saveAndFlush(sobrevivente); 

		return Boolean.TRUE;

	}

	/**
	 * Método para alterar localização do sobrevivente
	 * @param sobrevivente
	 * @return TRUE no término do método.
	 */
	
	public Boolean alterarLocalizacao(Sobrevivente sobrevivente) { 

		Sobrevivente sobreviventeLoc = this.repository.findOne(sobrevivente.getId()); 
		
		if (sobreviventeLoc.isInfectado()) { 
			
			return Boolean.FALSE;

		} else {

			sobreviventeLoc.setLatitude(sobrevivente.getLatitude()); 
			
			sobreviventeLoc.setLongitude(sobrevivente.getLongitude()); 

			this.repository.saveAndFlush(sobreviventeLoc); 

			return Boolean.TRUE;

		}

	}

	/**
	 * Função responsável por retornar uma lista com todos os sobreviventes,
	 * e seus respectivos inventários
	 * @return A lista ao fim do método.
	 */
	public List<Sobrevivente> obterTodos() {

		List<Sobrevivente> lista = this.repository.findAll();

		lista.forEach(sobrevivente -> {

			sobrevivente.getInventario().setItens(inventarioRepository.findByInventario(sobrevivente.getInventario()));
		

		});

		return lista; 
	}

	/**
	 * Função para retornar um relátorio da porcentagem dos infectados,
	 * dos não infectados, da média dos itens.
	 * @return O relatório ao fim do método.
	 */
	public Relatorio obterRelatorio() {
		
		Relatorio relatorio = new Relatorio();
		
		Integer qtdTotal = this.repository.obterQtdTotal();
		
		this.definePercentuais(relatorio, qtdTotal);
		
		calculaQtdAguaPorSobrevivente(relatorio, qtdTotal);
		
		Integer qtdComida = this.inventarioRepository.obterQuantidadeComida();
		
		Integer mediaComida = (qtdComida/qtdTotal);
		
		relatorio.setQtdComidaPorSobrevivente(mediaComida.toString());
		
		Integer qtdMedicacao = this.inventarioRepository.obterQuantidadeMedicacao();
		
		Integer mediaMedicacao = (qtdMedicacao/qtdTotal);
		
		relatorio.setQtdMedicacaoPorSobrevivente(mediaMedicacao.toString());
		
		Integer qtdMunicao = this.inventarioRepository.obterQuantidadeMunicao();
		
		Integer mediaMunicao = (qtdMunicao/qtdTotal);
		
		relatorio.setQtdMunicaoPorSobrevivente(mediaMunicao.toString());
		
		calculaPontosPerdidos(relatorio);
		
		return relatorio;
	}

	private void calculaQtdAguaPorSobrevivente(Relatorio relatorio, Integer qtdTotal) {
		Integer qtdAgua = this.inventarioRepository.obterQuantidadeAgua();
		
		Integer mediaAgua = (qtdAgua/qtdTotal);

		relatorio.setQtdAguaPorSobrevivente(mediaAgua.toString());
	}

	private void calculaPontosPerdidos(Relatorio relatorio) {
		
		List<Sobrevivente> lista = this.repository.findAll();
		
		lista.forEach(sobrevivente -> {
			
			if(sobrevivente.isInfectado()) {
					
				sobrevivente.getInventario().setItens(inventarioRepository.findByInventario(sobrevivente.getInventario()));
				
				Integer pontuacaoTotal = 0;
				
				for (ItemInventario itemInventario : sobrevivente.getInventario().getItens()) {
				
					pontuacaoTotal += itemInventario.getTipo().getPonto() * itemInventario.getQtdItem();
					
				}
				
				relatorio.setPontosPerdidos(pontuacaoTotal.toString() + " Pontos.");
			}
		});
	}

	private void definePercentuais(Relatorio relatorio, Integer qtdTotal) {
		
		Integer qtdInfectado = this.repository.obterQtdInfectado();
		
		Integer qtdSobrevivente = qtdTotal - qtdInfectado;
		
		DecimalFormat formato = new DecimalFormat("#.##");      
		
		Double porcentagemInfectado = Double.valueOf(qtdInfectado) * 100 / Double.valueOf(qtdTotal);
		
		Double porcentagemNaoInfectado = Double.valueOf(qtdSobrevivente) * 100 / Double.valueOf(qtdTotal);
		
		relatorio.setPercentualInfectado((formato.format(porcentagemInfectado)) + "%");
		
		relatorio.setPercentualNaoInfectado((formato.format(porcentagemNaoInfectado)) + "%");
	}

}
