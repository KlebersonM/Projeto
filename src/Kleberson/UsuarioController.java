package Kleberson;

import java.util.HashSet;
import java.util.Set;


public class UsuarioController {


	private Set<Usuario> usuarios;
	
	public UsuarioController(){
		
		usuarios = new HashSet<>();
	}

	public void cadastraUsuario(String nome, String telefone, String email) {
		
		Usuario usuario = new Usuario(nome, telefone, email);
		usuarios.add(usuario);
	}


	public String getInfoUsuario(String nome, String telefone, String atributo) {
		
		if (atributo.toLowerCase().equals("email"))
			if (usuarioExiste(nome, telefone))
				return getUsuario(nome, telefone).getEmail();
			else{
				return null; //excessão futuramente
			}
		return null; //excessão futuramente
	}

	public void removerUsuario(String nome, String telefone) {


		if (usuarioExiste(nome, telefone))
			usuarios.remove(getUsuario(nome, telefone));
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		
		Usuario usuario = getUsuario(nome, telefone);
		if(atributo.toLowerCase().equals("email"))
			usuario.setEmail(valor);
		else if(atributo.toLowerCase().equals("nome"))
			usuario.setNome(valor);
		else if(atributo.toLowerCase().equals("telefone"))
			usuario.setCelular(valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {

		Usuario usuario = getUsuario(nome, telefone);
		Item eletronico = new JogosEletronicos(nomeItem, preco, plataforma);
		usuario.adicionaItem(eletronico);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		
		Usuario usuario = getUsuario(nome, telefone);
		Item tabuleiro = new JogosTabuleiro(nomeItem, preco);	
		usuario.adicionaItem(tabuleiro);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {

		Usuario usuario = getUsuario(nome, telefone);
		JogosTabuleiro item = (JogosTabuleiro) usuario.getItem(nomeItem);
		item.adicionaPecaPerdida(nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {

		Usuario usuario = getUsuario(nome, telefone);
		Item filme = new BlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		usuario.adicionaItem(filme);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {

		Usuario usuario = getUsuario(nome, telefone);
		Item show = new BlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		usuario.adicionaItem(show);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {

		Usuario usuario = getUsuario(nome, telefone);
		Item serie = new BluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		usuario.adicionaItem(serie);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {

		Usuario usuario = getUsuario(nome, telefone);
		BluraySerie serie = (BluraySerie) usuario.getItem(nomeBlurayTemporada);
		serie.adicionaBluRay(duracao);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {

		Usuario usuario = getUsuario(nome, telefone);
		Item item = usuario.getItem(nomeItem);
		if (atributo.toLowerCase().equals("nome"))
			return item.getNome();
		else if (atributo.toLowerCase().equals("valor"))
			return String.valueOf(item.getValor()); 
		return null;
	}

	public void removerItem(String nome, String telefone, String nomeItem){

		Usuario usuario = getUsuario(nome, telefone);
		usuario.removeItem(nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {

		Usuario usuario = getUsuario(nome, telefone);
		usuario.atualizaItem(nomeItem, atributo, valor);
	}

	public String listarItensOrdenadosPorNome() {

		return null;
	}

	public String listarItensOrdenadosPorValor() {

		return null;
	}

	public String pesquisarDetalhesItem() {

		return null;
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {		
	
		
	}
	
	
	private boolean usuarioExiste(String nome, String telefone) {
		
		for (Usuario usuario : usuarios){
			if(usuario.getNome().equals(nome))
				if(usuario.getCelular().equals(telefone))
					return true;
		}
		return false;
	}

	private Usuario getUsuario(String nome, String telefone) {

		for (Usuario usuario : usuarios){
			if(usuario.getNome().equals(nome))
				if(usuario.getCelular().equals(telefone))
					return usuario;
		}
		return null;
	}
}
