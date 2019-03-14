
package model;

import java.util.Objects;

/**
 *
 * @author Joni
 */
public class DetalhesObra {
    
    private Long id;
    private String titulo;
    private String data;
    private String tecnico;
    private String dimensoe_fisica;
    private String autor;
    private String procedencia;
    private String tipo;

    public DetalhesObra() {
    }

    public DetalhesObra(Long id, String titulo, 
            String data, String tecnico, String dimensoe_fisica, 
            String autor, String procedencia, String tipo) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.tecnico = tecnico;
        this.dimensoe_fisica = dimensoe_fisica;
        this.autor = autor;
        this.procedencia = procedencia;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getDimensoe_fisica() {
        return dimensoe_fisica;
    }

    public void setDimensoe_fisica(String dimensoe_fisica) {
        this.dimensoe_fisica = dimensoe_fisica;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalhesObra other = (DetalhesObra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
