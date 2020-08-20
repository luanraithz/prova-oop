// Luan Raithz Machado
package furb;

import furb.viagem.Empresa;

import java.io.File;
import java.io.FileInputStream;

public class Main  {

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Home home = new Home(empresa);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
    }
}
