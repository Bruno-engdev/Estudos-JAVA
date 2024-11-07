package ProjetoFaculdade;

public class CadastroFuncionário {
    public String nome;
    public String senha;
    private String nomeCompleto;
    private String dataDeNascimento;
    private String genero;
    private String rua;
    private String numeroCasa;
    private String bairro;
    private String estado;
    private String CEP;
    private int telefone;
    private String email;
    private String numerodeidentificacaoCPF;
    private String cargo;
    private String departamento;
    private String datadeAdmissão;
    private String Salário;
    private String tipodecontrato;
    private String CargaHorária;
    private String supervisorResponsável;
    private String níveldeescolaridade;
    private String InstituiçãodeEnsino;
    private String Curso;
    private int anodeConclusão;
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public CadastroFuncionário(String nomeCompleto, String dataDeNascimento, String genero, String rua,
            String numeroCasa, String bairro, String estado, String CEP, int telefone, String email) {
        this.nomeCompleto = nomeCompleto;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.estado = estado;
        this.CEP = CEP;
        this.telefone = telefone;
        this.email = email;
    }

    public boolean validarCPF(String cpf) {
        String regex = "^(?!000|111|222|333|444|555|666|777|888|999)\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        return cpf.matches(regex);
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String cEP) {
        CEP = cEP;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumerodeidentificacaoCPF() {
        return numerodeidentificacaoCPF;
    }
    public void setNumerodeidentificacaoCPF(String numerodeidentificacaoCPF) {
        this.numerodeidentificacaoCPF = numerodeidentificacaoCPF;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getDatadeAdmissão() {
        return datadeAdmissão;
    }
    public void setDatadeAdmissão(String datadeAdmissão) {
        this.datadeAdmissão = datadeAdmissão;
    }
    public String getSalário() {
        return Salário;
    }
    public void setSalário(String salário) {
        Salário = salário;
    }
    public String getTipodecontrato() {
        return tipodecontrato;
    }
    public void setTipodecontrato(String tipodecontrato) {
        this.tipodecontrato = tipodecontrato;
    }
    public String getCargaHorária() {
        return CargaHorária;
    }
    public void setCargaHorária(String cargaHorária) {
        CargaHorária = cargaHorária;
    }
    public String getSupervisorResponsável() {
        return supervisorResponsável;
    }
    public void setSupervisorResponsável(String supervisorResponsável) {
        this.supervisorResponsável = supervisorResponsável;
    }
    public String getNíveldeescolaridade() {
        return níveldeescolaridade;
    }
    public void setNíveldeescolaridade(String níveldeescolaridade) {
        this.níveldeescolaridade = níveldeescolaridade;
    }
    public String getInstituiçãodeEnsino() {
        return InstituiçãodeEnsino;
    }
    public void setInstituiçãodeEnsino(String instituiçãodeEnsino) {
        InstituiçãodeEnsino = instituiçãodeEnsino;
    }
    public String getCurso() {
        return Curso;
    }
    public void setCurso(String curso) {
        Curso = curso;
    }
    public int getAnodeConclusão() {
        return anodeConclusão;
    }
    public void setAnodeConclusão(int anodeConclusão) {
        this.anodeConclusão = anodeConclusão;
    }
}
