package lottoalkalmazas.felulet;

import lottoalkalmazas.logika.Lotto;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameLotto extends JFrame implements ActionListener{
    private JTextField txtFldLottoszamok;
    private JButton btnSorsol;
    private JButton btnRendez;
    private JButton btnUjJatek;
    private JPanel pnlAblak;
    private JComboBox cmbLottoTipus;
    
    private Lotto l;
    
    public FrameLotto() {
        initComponents();
    }
    
    private void initComponents(){
        this.setTitle("Lotto");
        this.setSize(300,600);
        this.setLocationRelativeTo(null); //középre igazítja az ablakot
        
        this.pnlAblak = (JPanel)this.getContentPane();
        this.pnlAblak.setLayout(null);
        this.txtFldLottoszamok = new JTextField();
        this.txtFldLottoszamok.setLocation(20, 20);
        this.txtFldLottoszamok.setSize(250, 25);
        this.txtFldLottoszamok.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        
        this.btnSorsol = new JButton();
        this.btnSorsol.setText("Sorsol");
        this.btnSorsol.setLocation(20, 50);
        this.btnSorsol.setSize(250,25);
        this.btnSorsol.addActionListener(this);
        this.btnSorsol.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        
        this.btnRendez = new JButton();
        this.btnRendez.setText("Rendez");
        this.btnRendez.setLocation(20, 80);
        this.btnRendez.setSize(250,25);
        this.btnSorsol.addActionListener(this);
        this.btnRendez.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        
        this.btnUjJatek = new JButton();
        this.btnUjJatek.setText("Új játék");
        this.btnUjJatek.setLocation(20, 140);
        this.btnUjJatek.setSize(250,25);
        this.btnSorsol.addActionListener(this);
        this.btnUjJatek.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        
        this.cmbLottoTipus = new JComboBox();
        this.cmbLottoTipus.addItem("Ötöslottó");
        this.cmbLottoTipus.addItem("Hatoslottó");
        this.cmbLottoTipus.addItem("Skandináv");
        this.cmbLottoTipus.setLocation(20, 110);
        this.cmbLottoTipus.setSize(250,25);
        this.cmbLottoTipus.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        
        this.pnlAblak.add(this.txtFldLottoszamok);
        this.pnlAblak.add(this.btnSorsol);
        this.pnlAblak.add(this.cmbLottoTipus);
        this.pnlAblak.add(this.btnRendez);
        this.pnlAblak.add(this.btnUjJatek);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.btnSorsol)){
            int type = 0;
            switch(cmbLottoTipus.getSelectedIndex()){
                case 0:
                    type = 5;
                    break;
                case 1:
                    type = 6;
                    break;
                case 2:
                    type = 7;
                    break;
            }
            l = new Lotto(type);
            l.Sorsol();
            this.txtFldLottoszamok.setText(l.toString());
        }
    }
}
