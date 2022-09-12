package entity;

import javax.persistence.*;


@Entity
@Table (name = "tb_buku")

public class tes1 {

    @Id
    @GeneratedValue
    @Column(name = "id_buku")
    private Integer idBuku;
    @Column(name = "kode_buku")
    private Integer kodeBuku;
    @Column(name ="judul_buku")
    private String judulBuku;

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Integer getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(Integer kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }


    public tes1(Integer idBuku, Integer kodeBuku, String judulBuku) {
        this.idBuku = idBuku;
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
    }

    public tes1 () {

    }
}
