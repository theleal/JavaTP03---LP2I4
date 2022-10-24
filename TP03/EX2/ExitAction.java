/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

import java.awt.event.*;

public class ExitAction extends WindowAdapter implements ActionListener {

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}