package pe.com.srmasset.srmappwsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h1>Evaluation Model</h1>
 * <p>
 *  Data Model Evaluation
 * </p>
 * @author Zeler Benji Villarreal Marcelo
 * @since 10/11/2018
 * @version 1.0.0
 */
@Table(name = "Evaluation")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String clientName;
    @Column
    private BigDecimal limCredit;
    @Column
    private BigDecimal porcInterest;
    @Column
    private String typeOfEvaluation;
}
