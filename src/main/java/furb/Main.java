// Luan Raithz Machado
package furb;

import furb.viagem.Empresa;
import furb.viagem.Viagem;

import javax.swing.*;
import java.io.*;

public class Main  {

    private static Empresa getInitialState() {
        try {
            FileInputStream fileStream = new FileInputStream("save");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
            Empresa empresa = (Empresa) objectInputStream.readObject();
            objectInputStream.close();
            return empresa;
        } catch (FileNotFoundException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Empresa();
    }

    public static void main(String[] args) {
        Home home = new Home(getInitialState());
        home.setLocationRelativeTo(null);
        home.setVisible(true);
    }
}
