import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MenuBar {

	private Font textFont = new Font("Century Gothic",Font.PLAIN,20);
	private Font uiFont = new Font("Century Gothic",Font.BOLD,15);
	// JFrame
	private JFrame frame;
	// MenuBar
	private JMenuBar menuBar;
	// Main Menus
	private JMenu manageMenu;
	private JMenu search;
	// Sub Menus
	private JMenu addElement;
	private JMenu removeElement;
	private JMenu updateElement;
	// Search components
	private JMenuItem searchMovies;
	private JMenuItem searchActors;
	private JMenuItem searchDirectors;
	private JMenuItem searchStudios;
	private JMenuItem searchAwards;
	// Management Components
	private JMenuItem addDirector;
	private JMenuItem removeDirector;
	private JMenuItem updateDirector;
	private JMenuItem addMovie;
	private JMenuItem removeMovie;
	private JMenuItem updateMovie;
	private JMenuItem addActor;
	private JMenuItem removeActor;
	private JMenuItem updateActor;
	private JMenuItem addStudio;
	private JMenuItem removeStudio;
	private JMenuItem updateStudio;
	private JMenuItem addAward;
	private JMenuItem removeAward;
	private JMenuItem updateAward;
	private JMenuItem logIn;
	private JFrame table;
	private JButton button;

	private JScrollPane resultPane;

	private JLabel label;

	Connection c;
	public MenuBar()  {


		// launch jframe
		frame = new JFrame("TERMINAL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();

		button = new JButton("Log In!");
		button.setFont(textFont);
		button.setSize(100,50);
		button.setLocation(614, 0);
		button.setBackground(Color.RED);
		// build the Edit menu
		manageMenu = new JMenu("Manage");
		logIn = new JMenuItem("Log in to manage database");
		manageMenu.add(logIn);

		// log in
		logInEvent e = new logInEvent();
		logIn.addActionListener(e);
		button.addActionListener(e);

		// build the search menu
		search = new JMenu("Search");
		searchMovies = new JMenuItem("for Movies...");
		searchActors = new JMenuItem("for Actors...");
		searchDirectors = new JMenuItem("for Directors...");
		searchAwards = new JMenuItem("for Awards...");
		searchStudios = new JMenuItem("for Studios...");
		search.add(searchMovies);
		search.add(searchActors);
		search.add(searchDirectors);
		search.add(searchAwards);
		search.add(searchStudios);
		// add menus to menubar
		menuBar.add(manageMenu);
		menuBar.add(search);

		// put the menubar on the frame
		frame.setJMenuBar(menuBar);

		// set the jframe
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(720, 600));
		//frame.setSize(720, 600);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		//frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
		frame.setLayout(null);
		frame.setVisible(true);

		// set the Jlabel
		label = new JLabel("label");
		label.setText("Not Logged In");
		label.setSize(500, 100);
		label.setLocation(590,470);
		label.setFont(textFont);
		label.setForeground(Color.black);

		// FONTS

		manageMenu.setFont(uiFont);
		search.setFont(uiFont);
		searchActors.setFont(uiFont);
		searchAwards.setFont(uiFont);
		searchDirectors.setFont(uiFont);
		searchMovies.setFont(uiFont);
		searchStudios.setFont(uiFont);
		logIn.setFont(uiFont);

		//there is no connection in the beginning
		c=null;


		// finally
		frame.add(label);
		frame.add(button);


		frame.repaint();
	}


	public void logIn() {

		// REMOVE BUTTON

		frame.remove(button);
		frame.repaint();
		// build the File menu

		manageMenu.remove(logIn);
		addElement = new JMenu("Add...");
		removeElement = new JMenu("Remove...");
		updateElement = new JMenu("Update...");

		// FONTS

		addElement.setFont(textFont);
		removeElement.setFont(textFont);
		updateElement.setFont(textFont);


		// Sub menu comp

		addDirector = new JMenuItem("...a new director");
		removeDirector = new JMenuItem("...an existing director");
		updateDirector = new JMenuItem("...an existing director");

		addMovie = new JMenuItem("...a new movie");
		removeMovie = new JMenuItem("...an existing movie");
		updateMovie = new JMenuItem("...an existing movie");

		addActor = new JMenuItem("...a new actor");
		removeActor = new JMenuItem("...an existing actor");
		updateActor = new JMenuItem("...an existing actor");

		addStudio = new JMenuItem("...a new studio");
		removeStudio = new JMenuItem("...an existing studio");
		updateStudio = new JMenuItem("...an existing studio");

		addAward = new JMenuItem("...a new award");
		removeAward = new JMenuItem("...an existing award");
		updateAward = new JMenuItem("...an existing award");

		manageMenu.add(addElement);
		manageMenu.add(removeElement);
		manageMenu.add(updateElement);

		addElement.add(addActor);
		addElement.add(addDirector);
		addElement.add(addMovie);
		addElement.add(addStudio);
		addElement.add(addAward);

		removeElement.add(removeActor);
		removeElement.add(removeDirector);
		removeElement.add(removeMovie);
		removeElement.add(removeStudio);
		removeElement.add(removeAward);

		updateElement.add(updateActor);
		updateElement.add(updateDirector);
		updateElement.add(updateMovie);
		updateElement.add(updateStudio);
		updateElement.add(updateAward);


		// FONTS

		addActor.setFont(uiFont);
		removeActor.setFont(uiFont);
		updateActor.setFont(uiFont);

		addDirector.setFont(uiFont);
		removeDirector.setFont(uiFont);
		updateDirector.setFont(uiFont);

		addMovie.setFont(uiFont);
		removeMovie.setFont(uiFont);
		updateMovie.setFont(uiFont);

		addStudio.setFont(uiFont);
		removeStudio.setFont(uiFont);
		updateStudio.setFont(uiFont);

		addAward.setFont(uiFont);
		removeAward.setFont(uiFont);
		updateAward.setFont(uiFont);

		// click events

		// DIRECTORS
		addDirector addD = new addDirector();
		addDirector.addActionListener(addD);

		removeDirector removeD = new removeDirector();
		removeDirector.addActionListener(removeD);

		updateDirector updateD = new updateDirector();
		updateDirector.addActionListener(updateD);

		// ACTORS

		addActor addA = new addActor();
		addActor.addActionListener(addA);

		removeActor removeA = new removeActor();
		removeActor.addActionListener(removeA);

		updateActor updateA = new updateActor();
		updateActor.addActionListener(updateA);

		// STUDIOS

		addStudio addS = new addStudio();
		addStudio.addActionListener(addS);

		removeStudio removeS = new removeStudio();
		removeStudio.addActionListener(removeS);

		updateStudio updateS = new updateStudio();
		updateStudio.addActionListener(updateS);

		// MOVIES

		addMovie addM = new addMovie();
		addMovie.addActionListener(addM);

		removeMovie removeM = new removeMovie();
		removeMovie.addActionListener(removeM);

		updateMovie updateM = new updateMovie();
		updateMovie.addActionListener(updateM);

		// AWARDS

		addAward addAW = new addAward();
		addAward.addActionListener(addAW);

		removeAward removeAW = new removeAward();
		removeAward.addActionListener(removeAW);

		updateAward updateAW = new updateAward();
		updateAward.addActionListener(updateAW); 

	}

	public class logInEvent implements ActionListener{


		public void actionPerformed(ActionEvent e) {

			JTextField username = new JTextField();
			JTextField password = new JPasswordField();
			Object[] message = {
					"Username:", username,
					"Password:", password
			};
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {

				c = Connector.CreateConnection("admin", "amk123"); //userame.gettext e cevir
				if ( c != null) {
					logIn();
					JOptionPane.showMessageDialog(null,"Successfully logged in!");
					label.setText("Logged in!");
				} else {
					JOptionPane.showMessageDialog(null,"Invalid username or password!");
				}
			} else {
				//JOptionPane.showMessageDialog(null,"Login Cancelled!");
			}

		}

	}

	public class addDirector implements ActionListener{//done

		public void actionPerformed(ActionEvent e) {
			JTextField directorName = new JTextField();
			Object[] message = {
					"Director Name:", directorName,
			};

			Statement st = null;
			int directorID = -1;
			try {
				st = c.createStatement();
				ResultSet rs= st.executeQuery("SELECT MAX(DIRECTOR_ID) FROM DIRECTOR");
				rs.next();
				directorID = rs.getInt(1);
				System.out.println(directorID);
			} catch (Exception e2) {
				// TODO: handle exception
			}


			int option = JOptionPane.showConfirmDialog(null, message, "New Director", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (directorName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Director name cannot be empty!");
				}

				else {
					// add director here
					try {
						st.executeQuery("INSERT INTO DIRECTOR VALUES(" + (directorID + 1) + ",'" + directorName.getText() + "')");
						JOptionPane.showMessageDialog(null, directorName.getText() + " successfully added to the database!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else {

				//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
			}

		}
	}
	public class removeDirector implements ActionListener{//done

		public void actionPerformed(ActionEvent e) {


			Statement st = null;
			int directorID = -1;
			try {
				table = new JFrame();



				table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM DIRECTOR"));



				table.setSize(new Dimension(800, 600));
				table.pack();
				table.setVisible(true);
				JTextField ID = new JTextField();
				Object[] message2 = {
						"ID you want to remove:", ID,
				};
				int deleteID = -1;
				int option2 = JOptionPane.showConfirmDialog(null, message2, "Delete Director", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					if (ID.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"ID Cannot be null!");
					}

					else {
						deleteID = Integer.parseInt(ID.getText());
						try {
							st = c.createStatement();
							st.executeQuery("DELETE FROM DIRECTOR WHERE DIRECTOR_ID = " + (deleteID) );
							table.setVisible(false);
							table = new JFrame();

							table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM DIRECTOR"));


							table.setSize(new Dimension(800, 600));
							table.pack();
							table.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {

					//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}




		}

	}
	public class updateDirector implements ActionListener{//done

		public void actionPerformed(ActionEvent e) {

		}

	}

	public class addActor implements ActionListener{//done

	public void actionPerformed(ActionEvent e) {
			JTextField actorName = new JTextField();
			JTextField actorHeight = new JTextField();
			JTextField actorWeight = new JTextField();
			JTextField actorHair = new JTextField();
			Object[] message = {
					"Actor Name:", actorName,
					"Actor Height:", actorHeight,
					"Actor Weight:", actorWeight,
					"Actor Hair:", actorHair
			};
			Statement st = null;
			int actorID = -1;
			try {
				st = c.createStatement();
				ResultSet rs= st.executeQuery("SELECT MAX(ACTOR_ID) FROM ACTOR");
				rs.next();
				actorID = rs.getInt(1);
				System.out.println(actorID);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			int option = JOptionPane.showConfirmDialog(null, message, "New Actor", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (actorName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Actor name cannot be empty!");
				}
				else {
					// add director here
					try {
						st.executeQuery("INSERT INTO ACTOR VALUES(" + (actorID + 1) + ",'" + actorName.getText() + "'," + Integer.parseInt(actorHeight.getText()) + "," +
								Integer.parseInt(actorWeight.getText()) + ",'" + actorHair.getText() + "')");
						JOptionPane.showMessageDialog(null, actorName.getText() + " successfully added to the database!");

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Something wrong has happened! Check your input!");
						e1.printStackTrace();
					}
				}

			} else {
				//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
			}

		}
	}
	public class removeActor implements ActionListener{//done

		public void actionPerformed(ActionEvent e) {

			Statement st = null;
			int actorID = -1;
			try {
				table = new JFrame();



				table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM ACTOR"));



				table.setSize(new Dimension(800, 600));
				table.pack();
				table.setVisible(true);
				JTextField ID = new JTextField();
				Object[] message2 = {
						"ID you want to remove:", ID,
				};
				int deleteID = -1;
				int option2 = JOptionPane.showConfirmDialog(null, message2, "Delete Actor", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					if (ID.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"ID Cannot be null!");
					}

					else {
						deleteID = Integer.parseInt(ID.getText());
						try {
							st = c.createStatement();
							st.executeQuery("DELETE FROM ACTOR WHERE ACTOR_ID = " + (deleteID) );
							table.setVisible(false);
							table = new JFrame();

							table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM ACTOR"));


							table.setSize(new Dimension(800, 600));
							table.pack();
							table.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {

					//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}




		}
	}
	public class updateActor implements ActionListener{

		public void actionPerformed(ActionEvent e) {

		}

	}

	public class addMovie implements ActionListener{//done


		public void actionPerformed(ActionEvent e) {

			JTextField movieName = new JTextField();

			JTextField movieBudget = new JTextField();
			JTextField movieBoxOffice = new JTextField();
			JTextField movieMPAA = new JTextField();
			JTextField movieDate = new JTextField();
			JTextField movieRating = new JTextField();
			Object[] message = {
					"Movie Title:", movieName,

					"Budget:", movieBudget,
					"Box Office:", movieBoxOffice,
					"MPAA Rating:", movieMPAA,
					"Release Date (YYYY/MM/DD):", movieDate,
					"Rating:", movieRating


			};
			Statement st = null;
			int movieID = -1;
			try {
				st = c.createStatement();
				ResultSet rs= st.executeQuery("SELECT MAX(MOVIE_ID) FROM MOVIE");
				rs.next();
				movieID = rs.getInt(1);
				System.out.println(movieID);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			int option = JOptionPane.showConfirmDialog(null, message, "New Movie", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (movieName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Movie name cannot be empty!");
				}
				else {
					try {
						st.executeQuery("INSERT INTO MOVIE VALUES(" + (movieID + 1) + ",'" + movieName.getText() + "',TO_DATE('" + movieDate.getText() + "', 'YYYY/MM/DD')," + Integer.parseInt(movieBoxOffice.getText()) +
								",'" + movieMPAA.getText() + "'," + Integer.parseInt(movieBudget.getText()) + "," + Integer.parseInt(movieRating.getText()) + ")");

						JOptionPane.showMessageDialog(null, movieName.getText() + " successfully added to the database!");

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Something wrong has happened! Check your input!");
						e1.printStackTrace();
					}
				}

			} else {
				//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
			}



		}

	}
	public class removeMovie implements ActionListener{


		public void actionPerformed(ActionEvent e) {

			Statement st = null;
			int MOVIEID = -1;
			try {
				table = new JFrame();



				table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM MOVIE"));



				table.setSize(new Dimension(800, 600));
				table.pack();
				table.setVisible(true);
				JTextField ID = new JTextField();
				Object[] message2 = {
						"ID you want to remove:", ID,
				};
				int deleteID = -1;
				int option2 = JOptionPane.showConfirmDialog(null, message2, "Delete MOVIE", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					if (ID.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"ID Cannot be null!");
					}

					else {
						deleteID = Integer.parseInt(ID.getText());
						try {
							st = c.createStatement();
							st.executeQuery("DELETE FROM MOVIE WHERE MOVIE_ID = " + (deleteID) );
							table.setVisible(false);
							table = new JFrame();

							table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM MOVIE"));


							table.setSize(new Dimension(800, 600));
							table.pack();
							table.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {

					//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}




		}

	}
	public class updateMovie implements ActionListener{


		public void actionPerformed(ActionEvent e) {


		}

	}

	public class addAward implements ActionListener{//done


		public void actionPerformed(ActionEvent e) {


			JTextField awardName = new JTextField();
			JTextField awardDate = new JTextField();

			Object[] message = {
					"Award Name:", awardName,
					"Award Date (YYYY/MM/DD):", awardDate



			};
			Statement st = null;
			int awardID = -1;
			try {
				st = c.createStatement();
				ResultSet rs= st.executeQuery("SELECT MAX(AWARD_ID) FROM AWARDS");
				rs.next();
				awardID = rs.getInt(1);
				System.out.println(awardID);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			int option = JOptionPane.showConfirmDialog(null, message, "New Award", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (awardName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Award name cannot be empty!");
				}
				else {
					try {
						st.executeQuery("INSERT INTO AWARDS VALUES('" + awardName.getText() + "',TO_DATE('" + awardDate.getText() + "', 'YYYY/MM/DD')," + (awardID + 1) + ")");

						JOptionPane.showMessageDialog(null, awardName.getText() + " successfully added to the database!");

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Something wrong has happened! Check your input!");
						e1.printStackTrace();
					}
				}

			} else {
				//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
			}




		}

	}
	public class removeAward implements ActionListener{


		public void actionPerformed(ActionEvent e) {

			Statement st = null;
			int AWARDID = -1;
			try {
				table = new JFrame();



				table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM AWARD"));



				table.setSize(new Dimension(800, 600));
				table.pack();
				table.setVisible(true);
				JTextField ID = new JTextField();
				Object[] message2 = {
						"ID you want to remove:", ID,
				};
				int deleteID = -1;
				int option2 = JOptionPane.showConfirmDialog(null, message2, "Delete AWARD", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					if (ID.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"ID Cannot be null!");
					}

					else {
						deleteID = Integer.parseInt(ID.getText());
						try {
							st = c.createStatement();
							st.executeQuery("DELETE FROM AWARD WHERE AWARD_ID = " + (deleteID) );
							table.setVisible(false);
							table = new JFrame();

							table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM AWARD"));


							table.setSize(new Dimension(800, 600));
							table.pack();
							table.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {

					//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}



		}

	}
	public class updateAward implements ActionListener{


		public void actionPerformed(ActionEvent e) {


		}

	}

	public class addStudio implements ActionListener{//done


		public void actionPerformed(ActionEvent e) {

			JTextField studioName = new JTextField();
			JTextField studioCEO = new JTextField();
			JTextField studioValue = new JTextField();

			Object[] message = {
					"Studio Name:", studioName,
					"Studio Ceo: ", studioCEO,
					"Studio Value:", studioValue



			};
			Statement st = null;
			int studioID = -1;
			try {
				st = c.createStatement();
				ResultSet rs= st.executeQuery("SELECT MAX(STUDIO_ID) FROM STUDIO");
				rs.next();
				studioID = rs.getInt(1);
				System.out.println(studioID);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			int option = JOptionPane.showConfirmDialog(null, message, "New Studio", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (studioName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Studio name cannot be empty!");
				}
				else {
					try {
						st.executeQuery("INSERT INTO STUDIO VALUES(" + (studioID+1) + ",'" + studioName.getText() + "','" + studioCEO.getText() +
								"'," + Integer.parseInt(studioValue.getText()) + ")");

						/*table = new JFrame("ANAN");
						table.add(TableCreator.createPanelWithResultSet(c, "SElect * from studio"));
						table.setSize(new Dimension(800, 600));
						table.pack();
						table.setVisible(true);*/



						JOptionPane.showMessageDialog(null, studioName.getText() + " successfully added to the database!");

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Something wrong has happened! Check your input!");
						e1.printStackTrace();
					}
				}

			} else {
				//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
			}
		}

	}
	public class removeStudio implements ActionListener{


		public void actionPerformed(ActionEvent e) {


			Statement st = null;
			int studioID = -1;
			try {
				table = new JFrame();



				table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM studio"));



				table.setSize(new Dimension(800, 600));
				table.pack();
				table.setVisible(true);
				JTextField ID = new JTextField();
				Object[] message2 = {
						"ID you want to remove:", ID,
				};
				int deleteID = -1;
				int option2 = JOptionPane.showConfirmDialog(null, message2, "Delete studio", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					if (ID.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"ID Cannot be null!");
					}

					else {
						deleteID = Integer.parseInt(ID.getText());
						try {
							st = c.createStatement();
							st.executeQuery("DELETE FROM studio WHERE studio_ID = " + (deleteID) );
							table.setVisible(false);
							table = new JFrame();

							table.add(TableCreator.createPanelWithResultSet(c, "SELECT * FROM studio"));


							table.setSize(new Dimension(800, 600));
							table.pack();
							table.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {

					//JOptionPane.showMessageDialog(null,"Adding Cancelled!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}



		}

	}
	public class updateStudio implements ActionListener{


		public void actionPerformed(ActionEvent e) {


		}

	}


}