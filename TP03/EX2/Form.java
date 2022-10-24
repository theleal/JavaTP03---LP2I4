/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.List;


public class Form extends JFrame implements ActionListener {

    private JLabel labelTitulo, labelAutor, labelEditora, labelAnoedicao, labelLocalizacao, labelStatus;
    private JTextField textTitulo, textAutor, textEditora, textAnoedicao, textLocalizacao, textStatus;
    private JPanel panelComponents, PanelButtons;
    private JButton btnOK, btnEmprestar, btnDevolver, btnMostrar, btnSair;

    private LivroDeBiblioteca livro;

    public Form() {

        livro = new LivroDeBiblioteca("O genio que habita em todos nos", "David Shrenk", "Zahar", (short)2011, "0000");

        setFormLayout();
        initializingComponents();
        addingComponentsOnForm();
        ActionEvents();
        Mostrar();
        Eventos();
        NovoObjeto();

    }

    private void setFormLayout() {
        setSize(500, 300);
        setTitle("Teste");
        setLayout(new BorderLayout(10, 10));
    }

    private void initializingComponents() {
        labelTitulo = new JLabel("Titulo :");
        textTitulo = new JTextField("");

        labelAutor = new JLabel("Autor :");
        textAutor = new JTextField("");

        labelEditora = new JLabel("Editora: ");
        textEditora = new JTextField("0");

        labelAnoedicao = new JLabel ("Ano de Edicao: ");
        textAnoedicao = new JTextField ("0");

        labelLocalizacao = new JLabel("Localizacao :");
        textLocalizacao = new JTextField("0");

        labelStatus = new JLabel("Status :");
        textStatus = new JTextField("0");


        btnOK = new JButton("Ok");
        btnEmprestar = new JButton("Emprestar");
        btnDevolver = new JButton("Devolver");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");
    }

    private void addingComponentsOnForm() {
        panelComponents = new JPanel();
        panelComponents .setLayout(new GridLayout(6,2, 0, 0));


        panelComponents.add(labelTitulo);
        panelComponents.add(textTitulo);

        panelComponents.add(labelAutor);
        panelComponents.add(textAutor);

        panelComponents.add(labelEditora);
        panelComponents.add(textEditora);

        panelComponents.add(labelAnoedicao);
        panelComponents.add(textAnoedicao);

        panelComponents.add(labelLocalizacao);
        panelComponents.add(textLocalizacao);

        panelComponents.add(labelStatus);
        panelComponents.add(textStatus);

        add(panelComponents, BorderLayout.CENTER);

        PanelButtons = new JPanel();
        PanelButtons .setLayout(new GridLayout(1, 3, 0, 0));

        PanelButtons.add(btnOK);
        PanelButtons.add(btnEmprestar);
        PanelButtons.add(btnDevolver);
        PanelButtons.add(btnMostrar);
        PanelButtons.add(btnSair);

        add(PanelButtons, BorderLayout.SOUTH);
    }

    private void ActionEvents() {
        addWindowListener(new ExitAction());
        btnSair.addActionListener(this);
    }

    public static void main(String args[])
    {
        Form Form = new Form();
        Form.setVisible(true);
    }

    private void Mostrar(){
        textTitulo.setText(livro.getTitulo());
        textAutor.setText(livro.getAutor());
        textEditora.setText(livro.getEditora());
        textAnoedicao.setText(livro.getAnoedicao() + "");
        textLocalizacao.setText(livro.getLocalizacao());
        textStatus.setText(livro.getEmprestado() + "");
    }

    private void Limpar() {
        textTitulo.setText("");
        textAutor.setText("");
        textEditora.setText("");
        textStatus.setText("");
        textLocalizacao.setText("");
        textAnoedicao.setText("");
    }

    private void Eventos(){
        addWindowListener(new ExitAction());
        btnSair.addActionListener(new ExitAction());

        btnOK.addActionListener(this);
        btnEmprestar.addActionListener(this);
        btnDevolver.addActionListener(this);
        btnMostrar.addActionListener(this);
    }

    private void Emprestar(){
        livro.Empresta();
    }

    private void Devolver(){
        livro.Devolve();
    }


    private void NovoObjeto() {
        LivroDeBiblioteca livroN = new LivroDeBiblioteca(
                textTitulo.getText(),
                textAutor.getText(),
                textEditora.getText(),
                Short.parseShort(textAnoedicao.getText()),
                textLocalizacao.getText()
        );

        livro = livroN;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {

            NovoObjeto();
            Limpar();
        }

        else if (e.getSource() == btnMostrar) {
            Mostrar();
        }

        else if (e.getSource() == btnEmprestar) {
            Emprestar();
        }

        else if (e.getSource() == btnDevolver) {
            Devolver();
        }

        else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }
}