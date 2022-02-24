package tech.prodigio.vehiclemilestraveled.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class Vehicle {

    private Long id;

    @NotNull
    private Long countyFips;

    @NotEmpty
    private String countyName;

    @NotEmpty
    private String stateName;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    private Long countyVmt;

    @NotNull
    private Long baselineJanVmt;

    @NotNull
    private Double percentChangeFromJan;

    @NotNull
    private Double mean7CountyVmt;

    @NotNull
    private Double mean7PercentChangeFromJan;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAtLow;

    @NotNull
    private Double mean7CountyVmtAtLow;

    @NotNull
    private Double percentChangeFromLow;

}
