package ar.edu.unlp.oo1.ejercicio1;

/**
 * Completar esta clase de acuerdo a lo especificado
 */
public class WallPost {
	
	String descriptionText;
	int likes;
	boolean isFeatured;
	
	public WallPost() {
		this.descriptionText = "Undefined post";
		this.likes = 0;
		this.isFeatured = false;		
	}
	
	/**
	 * Retorna el texto descriptivo de la publicación
	 * 
	 * @return
	 */
	String getText() {
		return this.descriptionText;
	};

	/**
	 * Setea el texto descriptivo de la publicación
	 * @param text
	 */
	void setText(String text) {
		this.descriptionText = text;
	};

	/**
	 * Retorna la cantidad de “me gusta”
	 * 
	 * @return
	 */
	int getLikes() {
		return this.likes;
	};

	/**
	 * Incrementa la cantidad de likes en uno
	 */
	void like() {
		this.likes++;
	};

	/**
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	 */
	void dislike() {
		if (this.likes > 0) {
			this.likes--;
		}
	};

	/**
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 * 
	 * @return
	 */
	boolean isFeatured() {
		return this.isFeatured;
	};

	/**
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	void toggleFeatured() {
		this.isFeatured = !this.isFeatured;
	};

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
			"text: " + getText() +
			", likes: '" + getLikes() + "'" +
			", featured: '" + isFeatured() + "'" +
			"}";
	}

}