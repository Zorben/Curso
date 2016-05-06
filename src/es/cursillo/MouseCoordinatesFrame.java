package es.cursillo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseCoordinatesFrame extends JFrame implements MouseMotionListener, MouseListener, FocusListener {

	JButton button;
	JTextField field;
	JLabel labelActionMouse;
	JLabel labelMotionMouse;

	public MouseCoordinatesFrame() {
		super();
		initComponents();
	}

	public MouseCoordinatesFrame(String title) {
		this();
		setTitle(title);
	}

	private void initComponents() {
		pack();
		configureForm();
		addComponentsToFrame();
		setLayout(null);
		addListeners();
		configureWindow();
	}

	private void configureWindow() {
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void configureForm() {
		button = new JButton("Click me");
		button.setBounds(40, 90, 100, 40);

		field = new JTextField();
		field.setBounds(40, 40, 100, 40);

		labelActionMouse = new JLabel("acciones");
		labelActionMouse.setBounds(40, 140, 200, 40);

		labelMotionMouse = new JLabel("movimiento");
		labelMotionMouse.setBounds(40, 190, 200, 40);
	}

	private void addComponentsToFrame() {
		add(button);
		add(field);
		add(labelActionMouse);
		add(labelMotionMouse);
	}

	private void addListeners() {
		addMouseListener(this);
		addMouseMotionListener(this);
		field.addFocusListener(this);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					field.setText("clicked");
				}
			}
		});
	}



	@Override
	public void focusGained(FocusEvent e) {
		button.setText("foco obtenido");
	}

	@Override
	public void focusLost(FocusEvent e) {
		button.setText("foco obtenido");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		labelActionMouse.setText("mouseClicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		labelActionMouse.setText("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		labelActionMouse.setText("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		labelActionMouse.setText("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		labelActionMouse.setText("mouseExited");
		labelMotionMouse.setText("sin posicion determinada");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		labelActionMouse.setText("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		labelMotionMouse.setText("x: " + e.getX() + ", y:" + e.getY());
	}

}
