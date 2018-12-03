package medion.tango;

import com.google.gson.annotations.SerializedName;

public class HistoryModel {
    @SerializedName("vacid")
    private String vacid;
    @SerializedName("custname")
    private String custname;
    @SerializedName("plasmaname")
    private String plasmaname;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("phone")
    private String phone;
    @SerializedName("area")
    private String area;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("populasi")
    private String populasi;
    @SerializedName("jenis")
    private String jenis;
    @SerializedName("umur")
    private String umur;
    @SerializedName("aplikasi")
    private String aplikasi;
    @SerializedName("productname")
    private String productname;

    @SerializedName("donumber")
    private String donumber;
    @SerializedName("batch")
    private String batch;
    @SerializedName("kmstart")
    private String kmstart;
    @SerializedName("kmfinish")
    private String kmfinish;
    @SerializedName("remark")
    private String remark;
    @SerializedName("reschedule")
    private String reschedule;
    @SerializedName("newdate")
    private String newdate;
    @SerializedName("cancel")
    private String cancel;


    public HistoryModel(String vacid, String custname, String plasmaname, String address,
                        String city, String phone, String area, String tanggal, String populasi,
                        String jenis, String umur, String aplikasi, String productname,
                        String donumber, String batch, String kmstart, String kmfinish,
                        String remark, String reschedule, String newdate, String cancel) {

        this.vacid = vacid;
        this.custname = custname;
        this.plasmaname = plasmaname;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.area = area;
        this.tanggal = tanggal;
        this.populasi = populasi;
        this.jenis = jenis;
        this.umur = umur;
        this.aplikasi = aplikasi;
        this.productname = productname;

        this.donumber = donumber;
        this.batch = batch;
        this.kmstart = kmstart;
        this.kmfinish = kmfinish;
        this.remark = remark;
        this.reschedule = reschedule;
        this.newdate = newdate;
        this.cancel = cancel;
    }

    public String getVacid() {return vacid;}
    public void setVacid(String vacid) {this.vacid = vacid;}

    public String getCustName() {return custname;}
    public void setCustName(String custname) {this.custname = custname;}

    public String getPlasmaName() {return plasmaname;}
    public void setPlasmaName(String plasmaname) {this.plasmaname = plasmaname;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}

    public String getTanggal() {return tanggal;}
    public void setTanggal(String tanggal) {this.tanggal = tanggal;}

    public String getPopulasi() {return populasi;}
    public void setPopulasi(String populasi) {this.populasi = populasi;}

    public String getJenis() {return jenis;}
    public void setJenis(String jenis) {this.jenis = jenis;}

    public String getUmur() {return umur;}
    public void setUmur(String umur) {this.umur = umur;}

    public String getAplikasi() {return aplikasi;}
    public void setAplikasi(String aplikasi) {this.aplikasi = aplikasi;}

    public String getProductname() {return productname;}
    public void setProductname(String productname) {this.productname = productname;}


    public String getDonumber() {return donumber;}
    public void setDonumber(String donumber) {this.donumber = donumber;}

    public String getBatch() {return batch;}
    public void setBatch(String batch) {this.batch = batch;}

    public String getKmstart() {return kmstart;}
    public void setKmstart(String kmstart) {this.kmstart = kmstart;}

    public String getKmfinish() {return kmfinish;}
    public void setKmfinish(String kmfinish) {this.kmfinish = kmfinish;}

    public String getRemark() {return remark;}
    public void setRemark(String remark) {this.remark = remark;}

    public String getReschedule() {return reschedule;}
    public void setReschedule(String reschedule) {this.reschedule = reschedule;}

    public String getNewdate() {return newdate;}
    public void setNewdate(String newdate) {this.newdate = newdate;}

    public String getCancel() {return cancel;}
    public void setCancel(String cancel) {this.cancel = cancel;}
}
