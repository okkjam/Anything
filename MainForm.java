import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.management.InstanceNotFoundException;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MainForm extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField TF_no, TF_name, TF_amount, TF_price, TF_note, TF_indate;	
	private JTextField ITno, ITname, ITprice, ITamount, ITindate, ITnote;
	
	private JButton BTdelete, BTupdate, BTinsert, BTselect;
	private JButton IBok, IBno;
	
	private JLabel LB_no, LB_name, LB_temp, LB_amount, LB_price, LB_indate, LB_note;	
	
	private JTable table;

	private JRadioButton RBT_1, RBT_2, RBT_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	JFrame frame3 = new JFrame();


	List<ProductDTO> allproductList = ProductDAO.getDAO().allProduct();
	

	public MainForm() throws Exception{
		setBackground(Color.PINK);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel Title = new JLabel("\uBC1C\uC8FC \uBB3C\uD488 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		Title.setFont(new Font("나눔고딕코딩", Font.BOLD, 24));
		Title.setBounds(359, 12, 276, 67);
		contentPane.add(Title);
		

		setResizable(false);

		setBounds(400, 200, 1000, 600);
		

		LB_no = new JLabel("\uC81C\uD488\uBC88\uD638");
		LB_no.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_no.setBounds(62, 92, 83, 18);
		contentPane.add(LB_no);
		
		LB_name = new JLabel("\uC81C \uD488 \uBA85");
		LB_name.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_name.setBounds(62, 144, 83, 18);
		contentPane.add(LB_name);
		
		LB_temp = new JLabel("\uBC1C\uC8FC\uC0C1\uD0DC");
		LB_temp.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_temp.setBounds(642, 188, 83, 18);
		contentPane.add(LB_temp);
		
		LB_amount = new JLabel("\uC218    \uB7C9");
		LB_amount.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_amount.setBounds(364, 144, 83, 18);
		contentPane.add(LB_amount);
		
		LB_price = new JLabel("\uAE08    \uC561");
		LB_price.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_price.setBounds(364, 92, 83, 18);
		contentPane.add(LB_price);	
		
		LB_indate = new JLabel("\uC785 \uACE0 \uC77C");
		LB_indate.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_indate.setBounds(681, 92, 83, 18);
		contentPane.add(LB_indate);
		
		LB_note = new JLabel("\uBE44    \uACE0");
		LB_note.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
		LB_note.setBounds(681, 144, 83, 18);
		contentPane.add(LB_note);
						
		TF_no = new JTextField();
		TF_no.setForeground(Color.BLACK);
		TF_no.setBackground(SystemColor.inactiveCaption);
		TF_no.setBounds(143, 88, 165, 27);
		contentPane.add(TF_no);
		TF_no.setColumns(10);
		
		TF_name = new JTextField();
		TF_name.setForeground(Color.BLACK);
		TF_name.setBackground(SystemColor.inactiveCaptionBorder);
		TF_name.setColumns(10);
		TF_name.setBounds(143, 140, 165, 27);
		contentPane.add(TF_name);
		
		TF_amount = new JTextField();
		TF_amount.setForeground(Color.BLACK);
		TF_amount.setBackground(SystemColor.inactiveCaption);
		TF_amount.setColumns(10);
		TF_amount.setBounds(445, 140, 165, 27);
		contentPane.add(TF_amount);

		TF_price = new JTextField();
		TF_price.setForeground(Color.BLACK);
		TF_price.setBackground(SystemColor.inactiveCaption);
		TF_price.setColumns(10);
		TF_price.setBounds(445, 88, 165, 27);
		contentPane.add(TF_price);

		TF_note = new JTextField();
		TF_note.setForeground(Color.BLACK);
		TF_note.setBackground(SystemColor.inactiveCaption);
		TF_note.setColumns(10);
		TF_note.setBounds(762, 140, 165, 27);
		contentPane.add(TF_note);
		
		TF_indate = new JTextField();
		TF_indate.setForeground(Color.BLACK);
		TF_indate.setBackground(SystemColor.inactiveCaption);
		TF_indate.setColumns(10);
		TF_indate.setBounds(762, 88, 165, 27);
		contentPane.add(TF_indate);		
		
		RBT_1 = new JRadioButton("\uB0C9\uB3D9");
		RBT_1.setBackground(Color.WHITE);
		buttonGroup.add(RBT_1);
		RBT_1.setSelected(true);
		RBT_1.setBounds(723, 184, 66, 27);
		contentPane.add(RBT_1);
		RBT_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allProduct(RBT_1.getText().toString());
			}
		});
		
		RBT_2 = new JRadioButton("\uB0C9\uC7A5");
		RBT_2.setBackground(Color.WHITE);
		buttonGroup.add(RBT_2);
		RBT_2.setBounds(791, 184, 66, 27);
		contentPane.add(RBT_2);
		RBT_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allProduct(RBT_2.getText().toString());
			}
		});
		
		RBT_3 =new JRadioButton("\uAE30\uD0C0");
		RBT_3.setBackground(Color.WHITE);
		buttonGroup.add(RBT_3);
		RBT_3.setBounds(861, 184, 66, 27);
		contentPane.add(RBT_3);
		RBT_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allProduct(RBT_3.getText().toString());
			}
		});
		

		BTselect = new JButton("\uC81C\uD488\uAC80\uC0C9");
		BTselect.setBackground(SystemColor.inactiveCaptionBorder);
		BTselect.setBounds(828, 239, 99, 27);
		contentPane.add(BTselect);
		

		BTdelete = new JButton("\uC81C\uD488\uC0AD\uC81C");
		BTdelete.setBackground(SystemColor.inactiveCaptionBorder);
		BTdelete.setBounds(828, 487, 99, 26);
		contentPane.add(BTdelete);
		

		BTupdate = new JButton("\uC81C\uD488\uC218\uC815");
		BTupdate.setBackground(SystemColor.inactiveCaptionBorder);
		BTupdate.setBounds(828, 405, 99, 27);
		contentPane.add(BTupdate);
		

		BTinsert = new JButton("\uC81C\uD488\uCD94\uAC00");
		BTinsert.setBackground(SystemColor.inactiveCaptionBorder);
		BTinsert.setBounds(828, 320, 99, 27);
		contentPane.add(BTinsert);
	

		Object[] title = {"제 품 번 호","제  품  명","금      액","수      량","발 주 상 태","입  고  일","비      고"};
		table = new JTable(new DefaultTableModel(title, 0));
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBackground(SystemColor.inactiveCaptionBorder);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		jsp.setBounds(50,230,750,300);
		getContentPane().add(jsp);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		TF_no.setEditable(false);
		TF_price.setEditable(false);
		TF_amount.setEditable(false);
		TF_indate.setEditable(false);
		TF_note.setEditable(false);
		
		BTselect.addActionListener(new BTEventHandler());
		BTinsert.addActionListener(new BTEventHandler());
		BTupdate.addActionListener(new BTEventHandler());
		BTdelete.addActionListener(new BTEventHandler());

		allProduct("냉동");
	}
	
	

	public class BTEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object Esource = e.getSource();
			if(Esource==BTselect) {
				select();
			} else if(Esource==BTinsert) {
				insertForm();
			} else if(Esource==BTupdate) {
				updateForm();
			} else if(Esource==BTdelete) {
				deleteForm();
			}
		}
	}
	
	public void select() {
		BTselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sname = TF_name.getText();
				if(sname.equals("")) {
					JOptionPane.showMessageDialog(TF_name, "제품명을 입력하세요");
					TF_name.requestFocus();
					return;
				}
				
				ProductDTO selectList = ProductDAO.getDAO().selectNameProduct(sname);
				
				
				if(selectList==null) {
					JOptionPane.showMessageDialog(TF_name, "해당 제품이 없습니다");
					return;
				}
				
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();

					Vector<Object> rowData = new Vector<Object>();
					
					rowData.add(selectList.getNo());
					rowData.add(selectList.getName());
					rowData.add(selectList.getPrice());
					rowData.add(selectList.getAmount());
					rowData.add(selectList.getTemp());
					rowData.add(selectList.getIndate());
					rowData.add(selectList.getNote());
					
					
					TF_no.setText(selectList.getNo());
					TF_name.setText(selectList.getName());
					TF_price.setText(selectList.getPrice());
					TF_amount.setText(selectList.getAmount());
					if(selectList.getTemp().equals("냉동")) {
						RBT_1.doClick();
					} else if(selectList.getTemp().equals("냉장")) {
						RBT_2.doClick();
					} else if(selectList.getTemp().equals("기타")) {
						RBT_3.doClick();
					}
					TF_indate.setText(selectList.getIndate());
					TF_note.setText(selectList.getNote());
					
					dtm.setNumRows(0);
					dtm.addRow(rowData);
				}
		});
	}
	
	
	public void insertForm() {
		frame1.getContentPane().setLayout(null);
		frame1.setTitle("제품 추가");
		frame1.setSize(400,340);
		frame1.setVisible(true);
		frame1.setLocation(700,300);
		frame1.setResizable(false);
		
		JLabel Ino = new JLabel("제 품 번 호");
		Ino.setBounds(50,30,80,30);
		frame1.getContentPane().add(Ino);
		
		JLabel Iname = new JLabel("제  품  명");
		Iname.setBounds(50,60,80,30);
		frame1.getContentPane().add(Iname);
		
		JLabel Iprice = new JLabel("금      액");
		Iprice.setBounds(50,90,80,30);
		frame1.getContentPane().add(Iprice);
		
		JLabel Iamount = new JLabel("수      량");
		Iamount.setBounds(50,120,80,30);
		frame1.getContentPane().add(Iamount);
		
		JLabel Itemp = new JLabel("발 주 상 태");
		Itemp.setBounds(50,150,80,30);
		frame1.getContentPane().add(Itemp);
		
		JLabel Iindate = new JLabel("입  고  일");
		Iindate.setBounds(50,180,80,30);
		frame1.getContentPane().add(Iindate);
		
		JLabel Inote = new JLabel("비      고");
		Inote.setBounds(50,210,80,30);
		frame1.getContentPane().add(Inote);
		
		ITno = new JTextField();
		ITno.setBounds(180,30,150,30);
		frame1.getContentPane().add(ITno);
		
		ITname = new JTextField();
		ITname.setBounds(180,60,150,30);
		frame1.getContentPane().add(ITname);
		
		ITprice = new JTextField();
		ITprice.setBounds(180,90,150,30);
		frame1.getContentPane().add(ITprice);
		
		ITamount = new JTextField();
		ITamount.setBounds(180,120,150,30);
		frame1.getContentPane().add(ITamount);
		
		RBT_1 = new JRadioButton("냉동");
		RBT_1.setBounds(180,150,65,30);
		frame1.getContentPane().add(RBT_1);
		buttonGroup2.add(RBT_1);
		
		RBT_2 = new JRadioButton("냉장");
		RBT_2.setBounds(245,150,65,30);
		frame1.getContentPane().add(RBT_2);
		buttonGroup2.add(RBT_2);
		
		RBT_3 = new JRadioButton("기타");
		RBT_3.setBounds(310,150,65,30);
		frame1.getContentPane().add(RBT_3);
		buttonGroup2.add(RBT_3);
		
		ITindate = new JTextField();
		ITindate.setBounds(180,180,150,30);
		frame1.getContentPane().add(ITindate);
		
		ITnote = new JTextField();
		ITnote.setBounds(180,210,150,30);
		frame1.getContentPane().add(ITnote);
		
		IBok = new JButton("확인");
		IBok.setBounds(130,260,60,30);
		frame1.getContentPane().add(IBok);
		IBok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		
		IBno = new JButton("취소");
		IBno.setBounds(230,260,60,30);
		frame1.getContentPane().add(IBno);
		IBno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame1.dispose();
			}
		});
	}
	
	public void insert() {
		String Inno = ITno.getText();
		String Inname = ITname.getText();
		String Inprice = ITprice.getText();
		String Inamount = ITamount.getText();
		String Intemp = null;
		String Inindate = ITindate.getText();
		String Innote = ITnote.getText();
		String Fno = "[0-9]*$";
		String Fprice = "[0-9]*$";
		String Famount = "[0-9]*$";
		//String Findate = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";
		
		if(RBT_1.isSelected()) {
			Intemp = "냉동";
		} else if(RBT_2.isSelected()) {
			Intemp = "냉장";
		} else if(RBT_3.isSelected()) {
			Intemp = "기타";
		}
		
		if(Inno.equals("")) {
			JOptionPane.showMessageDialog(ITno, "제품번호를 입력하세요");
			ITno.requestFocus();
			return;
		} else if(Inname.equals("")) {
			JOptionPane.showMessageDialog(ITname, "제품명을 입력하세요");
			ITname.requestFocus();
			return;
		} else if(Inprice.equals("")) {
			JOptionPane.showMessageDialog(ITprice, "금액을 입력하세요");
			ITprice.requestFocus();
			return;
		} else if(Inamount.equals("")) {
			JOptionPane.showMessageDialog(ITamount, "수량을 입력하세요");
			ITamount.requestFocus();
			return;
		} else if(Intemp==null) {
			JOptionPane.showMessageDialog(RBT_1, "발주상태를 선택하세요");
			return;
		} else if(!Pattern.matches(Fno, Inno)) {
			JOptionPane.showMessageDialog(ITno, "제품번호는 숫자로만 입력하세요");
			ITno.requestFocus();
			return;
		} else if(!Pattern.matches(Fprice, Inprice)) {
			JOptionPane.showMessageDialog(ITprice, "금액은 숫자로만 입력하세요");
			ITprice.requestFocus();
			return;
		} else if(!Pattern.matches(Famount, Inamount)) {
			JOptionPane.showMessageDialog(ITamount, "수량은 숫자로만 입력하세요");
			ITamount.requestFocus();
			return;
		}
		

		ProductDTO dto = new ProductDTO();
		dto.setNo(Inno);
		dto.setName(Inname);
		dto.setPrice(Inprice);
		dto.setAmount(Inamount);
		dto.setTemp(Intemp);
		dto.setIndate(Inindate);
		dto.setNote(Innote);
		
		
		ProductDAO.getDAO().insertProduct(dto);
		
		JOptionPane.showMessageDialog(IBok, "제품이 추가되었습니다");

		ITno.setText("");
		ITname.setText("");
		ITprice.setText("");
		ITamount.setText("");
		ITindate.setText("");
		ITnote.setText("");
		
		frame1.dispose();
		allProduct(Intemp);
	}
	
	
	//��ǰ ������
	public void updateForm() {
		frame2.getContentPane().setLayout(null);
		frame2.setTitle("제품 수정");
		frame2.setSize(400,360);
		frame2.setVisible(true);
		frame2.setLocation(700,300);
		frame2.setResizable(false);
		
		JLabel jName = new JLabel("제  품  명");
		jName.setBounds(70,50,80,30);
		frame2.getContentPane().add(jName);
		
		JLabel jPrice = new JLabel("금      액");
		jPrice.setBounds(70,90,80,30);
		frame2.getContentPane().add(jPrice);
		
		JLabel jAmount = new JLabel("수      량");
		jAmount.setBounds(70,130,80,30);
		frame2.getContentPane().add(jAmount);
		
		JLabel jIndate = new JLabel("입  고  일");
		jIndate.setBounds(70,170,80,30);
		frame2.getContentPane().add(jIndate);
		
		JLabel jNote = new JLabel("비      고");
		jNote.setBounds(70,210,80,30);
		frame2.getContentPane().add(jNote);
		
		TF_name = new JTextField();
		TF_name.setBounds(150, 50, 150, 30);
		frame2.getContentPane().add(TF_name);
		
		TF_price = new JTextField();
		TF_price.setBounds(150, 90, 150, 30);
		frame2.getContentPane().add(TF_price);
		
		TF_amount = new JTextField();
		TF_amount.setBounds(150, 130, 150, 30);
		frame2.getContentPane().add(TF_amount);
		
		TF_indate = new JTextField();
		TF_indate.setBounds(150, 170, 150, 30);
		frame2.getContentPane().add(TF_indate);
		
		TF_note = new JTextField();
		TF_note.setBounds(150, 210, 150, 30);
		frame2.getContentPane().add(TF_note);
		
		IBok = new JButton("확인");
		IBok.setBounds(130,260,60,30);
		frame2.getContentPane().add(IBok);
		IBok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		IBno = new JButton("취소");
		IBno.setBounds(240,260,60,30);
		frame2.getContentPane().add(IBno);
		IBno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
			}
		});
	}
	
	
	public void update() {
		String uName = TF_name.getText();
		String uPrice = TF_price.getText();
		String uAmount = TF_amount.getText();
		String uIndate = TF_indate.getText();
		String uNote = TF_note.getName();

		if(uName.equals("")) {
			JOptionPane.showMessageDialog(TF_name, "제품명을 입력하세요");
			TF_name.requestFocus();
			return;	
		}
		
		ProductDTO uDTO = new ProductDTO();
		uDTO.setPrice(TF_price.getText().toString());
		uDTO.setAmount(TF_amount.getText().toString());
		uDTO.setIndate(TF_indate.getText().toString());
		uDTO.setNote(TF_note.getText().toString());
		uDTO.setName(TF_name.getText().toString());
		
		ProductDAO.getDAO().updateProduct(uDTO);

		
		TF_price.setText("");
		TF_amount.setText("");
		TF_indate.setText("");
		TF_note.setText("");
		TF_name.setText("");
		
		RBT_1.doClick();
		JOptionPane.showMessageDialog(IBok, "제품이 수정되었습니다");
		frame2.dispose();
		
		allProduct(RBT_1.getText());
		
	}
	
	public void deleteForm() {
		frame3.getContentPane().setLayout(null);
		frame3.setTitle("제품 삭제");
		frame3.setSize(400,200);
		frame3.setVisible(true);
		frame3.setLocation(700,300);
		frame3.setResizable(false);
		
		JLabel dName = new JLabel("제  품  명");
		dName.setBounds(70,50,80,30);
		frame3.getContentPane().add(dName);
		
		TF_name = new JTextField();
		TF_name.setBounds(150, 50, 150, 30);
		frame3.getContentPane().add(TF_name);
		
		
		IBok = new JButton("확인");
		IBok.setBounds(140,110,60,30);
		frame3.getContentPane().add(IBok);
		IBok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		
		
		IBno = new JButton("취소");
		IBno.setBounds(240,110,60,30);
		frame3.getContentPane().add(IBno);
		IBno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame3.dispose();
			}
		});
	}
	
	public void delete() {
			String dename = TF_name.getText();
			
			ProductDTO dDTO = new ProductDTO();
			dDTO.setName(TF_name.getText().toString());
			
			ProductDAO.getDAO().deleteProduct(dDTO);
			
			TF_name.setText("");
			
			RBT_1.doClick();
			
			JOptionPane.showMessageDialog(IBok, "제품이 삭제되었습니다");
			frame3.dispose();
			
			allProduct(RBT_1.getText());
	}

	
	public static void main(String[] args) throws Exception {
		new MainForm();
	}
	
	
	//��ǰ���¿� ���� ��� ���� ��������
	public void allProduct(String temp) {
		List<ProductDTO> productList = ProductDAO.getDAO().allProduct();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		if(productList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "검색할 제품이 없습니다");
			return;
		}
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		for(ProductDTO product : productList) {
			Vector<Object> rowData = new Vector<Object>();
			if(product.getTemp().equals(temp)) {
				rowData.add(product.getNo());
				rowData.add(product.getName());
				rowData.add(product.getPrice());
				rowData.add(product.getAmount());
				rowData.add(product.getTemp());
				rowData.add(product.getIndate());
				rowData.add(product.getNote());
				
				model.addRow(rowData);
			}
		}
		
	}
}