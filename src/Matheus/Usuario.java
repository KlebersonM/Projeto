package Matheus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
	
	private String nome;
	private String email;
	private String telefone;
	
	private Set<Item> itens;
	
	
	public Usuario(String nome, String telefone, String email ){
		
		this.nome = nome;
		this.telefone = telefone ;
		this.email = email;
		itens = new HashSet<>();
		
	}

	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public String getCelular() {
		
		return telefone;
	}

	public void setCelular(String celular) {
		
		this.telefone = celular;
	}
	
	public void adicionaItem(Item item){
		
		itens.add(item);
	}
	
	public void removeItem(String nomeItem) {

		itens.remove(getItem(nomeItem));
	}	
	
	public void atualizaItem(String nomeItem, String atributo, String valor) {
		
		Item item = getItem(nomeItem);
		if (atributo.toLowerCase().equals("nome"))
			item.setNome(valor);
		else if (atributo.toLowerCase().equals("valor"))
			item.setValor(Double.valueOf(valor));
	}
	
	public Item getItem(String nomeItem){
		
		for (Item item : itens){
			if(item.getNome().equals(nomeItem))
				return item;
			}
		return null;
		}
	
	public List<Item> listaItens(List<Item> lista){
		
		for (Item item : itens){
			
			lista.add(item);
		}
		return lista;
	}

	@Override
	public String toString() {
		
		return this.nome + ", " +this.email + ", " + this.telefone;
	}

	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}