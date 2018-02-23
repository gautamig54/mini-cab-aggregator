import iiitb.ess201a7.a7base.Car;
import iiitb.ess201a7.a7base.Location;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class SwingDisplay extends Display {
	private JFrame frame;
	private JPanel canvas = null;
	private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, 
								Color.MAGENTA, Color.CYAN };
	
	private ArrayList<Car> cars;
	private ArrayList<Line> lines;
	private int startX, startY, endX, endY;
	private int selections = 0;
	
	public SwingDisplay() {
		cars = new ArrayList<Car>();
		lines = new ArrayList<Line>();
	}
	
	@Override
	public void init() {
		System.out.println("Starting new simulation");
		// start the GUI in the EDT thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setupGUI();
			}
		});
	}
	
	
	@Override
	public void draw(Car car) {
		// TODO Auto-generated method stub
		cars.add(car);
	}

	@Override
	public void drawLine(Location a, Location b) {
		// TODO Auto-generated method stub
		lines.add(new Line(a,b));
	}
	
	@Override
	public void update() {
		if(canvas != null) {
			canvas.repaint();
		}
	}
	@SuppressWarnings("serial")
	private void setupGUI() {
		frame = new JFrame("Map View of Fleets");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// set up a canvas for drawing the position of the cars
		// implement how cars should be rendered by overriding paintComponent
		canvas = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int i = 0;
				for(Car car: cars) {
					g.setColor(colors[i%6]);
					i++;
					Location loc = car.getLocation();
					g.drawOval(loc.getX(), loc.getY(), 10, 10);
					g.drawString("" + car.getId() + "-"
							+	car.getStatus(), loc.getX(), loc.getY() );
				}
				for(Line line: lines) {
					g.setColor(colors[i%6]);
					i++;
					g.drawLine(line.getStart().getX(), line.getStart().getY()
					, line.getEnd().getX(), line.getEnd().getY());
				}
				cars.clear();
				lines.clear();
			}
		};

		canvas.setPreferredSize(new Dimension(1000, 1000));
		frame.add(canvas, BorderLayout.LINE_START);

		JButton b1 = new JButton("New Trip");
		frame.add(b1, BorderLayout.PAGE_START);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// request trip
				if (selections == 2) {
					requestTrip(new Location(startX, startY), new Location(endX, endY));
					selections = 0;
				}
			}
		});

		JButton b2 = new JButton("Exit");
		frame.add(b2, BorderLayout.PAGE_END);

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(selections == 0) {
					startX = e.getX();
					startY = e.getY();
					selections++;
				} else if (selections == 1) {
					endX = e.getX();
					endY = e.getY();
					selections++;
				}
			}
		});
		
		// Display the window.
		frame.pack();
		frame.setVisible(true); // starts EDT if not already started
		// EDT continues until explicitly terminated with exit (or exception)

	}
}

class Line {
	private Location startp, endp;
	Line(Location s, Location e) {
		startp = s;
		endp = e;
	}
	
	Location getStart() { return startp; }
	Location getEnd() { return endp; }
	
}