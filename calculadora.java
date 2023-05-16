//Aram i Dani
package Calculadora;

import javax.swing.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class calculadora {
    public static class FinestraCalculadora extends JFrame {
        JTextField text;

        double resultado;

        String operacion;

        JPanel panelNumeros, panelOperaciones;

        boolean nuevaOperacion = true;

        public FinestraCalculadora() {

            super();

            ImageIcon uno= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\uno.PNG");
            ImageIcon dos= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\dos.PNG");
            ImageIcon tres= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\tres.PNG");
            ImageIcon cuatro= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\cuatro.PNG");
            ImageIcon cinco= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\cinco.PNG");
            ImageIcon seis= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\seis.PNG");
            ImageIcon siete= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\siete.PNG");
            ImageIcon ocho= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\ocho.PNG");
            ImageIcon nueve= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\nueve.PNG");
            ImageIcon zero= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\zero.PNG");
            ImageIcon punto= new ImageIcon("C:\\Users\\aramm\\OneDrive\\Escritorio\\DAM\\M03\\UF5\\Practiques\\src\\Calculadora\\punto.PNG");

            setSize(300, 380);
            setTitle("Calculadora");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);

            JPanel panell = (JPanel) this.getContentPane();
            panell.setLayout(new BorderLayout());


            //pantalla on apareixeran els numeros
            text = new JTextField("0", 20);
            text.setBorder(new EmptyBorder(4, 4, 4, 4));
            text.setFont(new Font("New Courier", Font.BOLD, 30));
            text.setHorizontalAlignment(JTextField.RIGHT);
            text.setEditable(false);
            text.setBackground(Color.WHITE);
            panell.add("North", text);

            panelNumeros = new JPanel();
            panelNumeros.setLayout(new GridLayout(4, 3));
            panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));


            nuevoBotonNumerico(siete,"7");
            nuevoBotonNumerico(ocho,"8");
            nuevoBotonNumerico(nueve,"9");
            nuevoBotonNumerico(cuatro,"4");
            nuevoBotonNumerico(cinco,"5");
            nuevoBotonNumerico(seis,"6");
            nuevoBotonNumerico(uno,"1");
            nuevoBotonNumerico(dos,"2");
            nuevoBotonNumerico(tres,"3");

            nuevoBotonNumerico(zero,"0");
            nuevoBotonNumerico(punto,".");

            panell.add("Center", panelNumeros);

            panelOperaciones = new JPanel();
            panelOperaciones.setLayout(new GridLayout(6, 1));
            panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

            nuevoBotonOperacion("+");
            nuevoBotonOperacion("-");
            nuevoBotonOperacion("*");
            nuevoBotonOperacion("/");
            nuevoBotonOperacion("=");
            nuevoBotonOperacion("CE");

            panell.add("East", panelOperaciones);

            validate();
        }

        private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
            Image img = icon.getImage();
            Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
        private void nuevoBotonNumerico(ImageIcon digito,String text) {
            JButton btn = new JButton();
            btn.setText(text);
            btn.setIcon(resizeIcon(digito, btn.getWidth()+70, btn.getHeight()+70));
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent evt) {
                    JButton btn = (JButton) evt.getSource();
                    numeroPulsado(btn.getText());
                }
            });

            panelNumeros.add(btn);
        }

        private void nuevoBotonOperacion(String operacion) {
            JButton btn = new JButton(operacion);
            btn.setForeground(Color.BLACK);

            btn.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseReleased(MouseEvent evt) {
                    JButton btn = (JButton) evt.getSource();
                    operacionPulsado(btn.getText());
                }
            });

            panelOperaciones.add(btn);
        }

        private void numeroPulsado(String digito) {
            if (text.getText().equals("0") || nuevaOperacion) {
                text.setText(digito);
            } else {
                text.setText(text.getText() + digito);
            }
            nuevaOperacion = false;
        }


        private void operacionPulsado(String tecla) {
            if (tecla.equals("=")) {
                calcularResultado();
            } else if (tecla.equals("CE")) {
                resultado = 0;
                text.setText("");
                nuevaOperacion = true;
            } else {
                operacion = tecla;
                if ((resultado > 0) && !nuevaOperacion) {
                    calcularResultado();
                } else {
                    resultado = new Double(text.getText());
                }
            }

            nuevaOperacion = true;
        }

        private void calcularResultado() {
            if (operacion.equals("+")) {
                resultado += new Double(text.getText());
            } else if (operacion.equals("-")) {
                resultado -= new Double(text.getText());
            } else if (operacion.equals("/")) {
                resultado /= new Double(text.getText());
            } else if (operacion.equals("*")) {
                resultado *= new Double(text.getText());
            }

            text.setText("" + resultado);
            operacion = "";
        }
    }
}





