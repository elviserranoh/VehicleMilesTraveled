package tech.prodigio.vehiclemilestraveled.infrastructure.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_VEHICLE")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "county_fips")
    private Long countyFips;

    @Column(name = "county_name")
    private String countyName;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "county_vmt")
    private Long countyVmt;

    @Column(name = "baseline_jan_vmt")
    private Long baselineJanVmt;

    @Column(name = "percent_change_from_jan")
    private Double percentChangeFromJan;

    @Column(name = "mean7_county_vmt")
    private Double mean7CountyVmt;

    @Column(name = "mean7_percent_change_from_jan")
    private Double mean7PercentChangeFromJan;

    @Column(name = "date_at_low")
    @Temporal(TemporalType.DATE)
    private Date dateAtLow;

    @Column(name = "mean7_county_vmt_at_low")
    private Double mean7CountyVmtAtLow;

    @Column(name = "percent_change_from_low")
    private Double percentChangeFromLow;

}