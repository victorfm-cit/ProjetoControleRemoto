package Aula06;

public class ControleRemoto implements Controlador {
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    //Metodos Especiais
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }
    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    //Metodos Abstrato
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }
    @Override
    public void abrirMenu() {
        System.out.println("--------MENU------");
        System.out.println("Está Ligado " + getLigado());
        System.out.println("Está Tocando " + getTocando());
        System.out.print("Volume " + getVolume());
        for (int i = 1; i <= this.getVolume(); i+=10) {
            System.out.print("| ");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println(" Fechando Menu ");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
           this.setVolume(this.getVolume() + 5);
        }
    }
    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 5);
        }
    }
    @Override
    public void ligarMudo() {
        if(this.getLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        }

    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);

        }
    }

    @Override
    public void pause() {
        if (this.getTocando() && this.getTocando()){
            this.setTocando(false);
        }
        else {
            System.out.println("Não consegui pausar");
        }
    }
}
