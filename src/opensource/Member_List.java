package opensource;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener,ActionListener{

    Vector v;   


    Vector cols;


    DefaultTableModel model;


    JTable jTable;


    JScrollPane pane;


    JPanel pbtn;


    JButton btnInsert;

    public Member_List(){
        super("회원관리 프로그램  v0.1.1");
        MemberDAO dao = new MemberDAO();
        v = dao.getMemberList();
        System.out.println("v="+v);
        cols = getColumn();
        jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane);
        pbtn = new JPanel();
        btnInsert = new JButton("회원가입");
        pbtn.add(btnInsert);
        add(pbtn,BorderLayout.NORTH);
        jTable.addMouseListener(this); //리스너 등록
        btnInsert.addActionListener(this); //회원가입버튼 리스너 등록
        setSize(600,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Vector getColumn(){
        Vector col = new Vector();
        col.add("아이디");
        col.add("비밀번호");
        col.add("이름");
        col.add("전화");
        col.add("주소");
        col.add("생일");
        col.add("직업");
        col.add("성별");
        col.add("이메일");
        col.add("자기소개");
        return col;
    }
    public void jTableRefresh(){
        MemberDAO dao = new MemberDAO();
        DefaultTableModel model= new DefaultTableModel(dao.getMemberList(), getColumn());
        jTable.setModel(model);     
    }
    public static void main(String[] args) {
        new Member_List();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int r = jTable.getSelectedRow();
        String id = (String) jTable.getValueAt(r, 0);
        MemberProc mem = new MemberProc(id,this);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnInsert ){
            new MemberProc(this);
        }
    }
}
