package paes.andrigo.carlos.ads.progweb.contpag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;

@Entity
// @Getter
// @Setter
@NoArgsConstructor

public class Contas {
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMes_vcto() {
        return mes_vcto;
    }

    public void setMes_vcto(String mes_vcto) {
        this.mes_vcto = mes_vcto;
    }

    public String getAno_vcto() {
        return ano_vcto;
    }

    public void setAno_vcto(String ano_vcto) {
        this.ano_vcto = ano_vcto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    Long id;
    
    String descricao;
    String mes_vcto;
    String ano_vcto;
    String valor;
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
