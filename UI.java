package userinput;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class UI {
private TextFieldCheck tCheck=new TextFieldCheck();
private JFrame mFrame;
	
	private JPanel Source,Target,DataQuality,FileName,TableProperties,DataBase,DQData,ColumnMetaData,RequiredColumns,TPanel,SPanel,EPanel;
	
	private JTextArea SourceDirectory;
	private JTextField SourceFileFormat,SourceFileType,ColumnDelimiter;
	private JLabel SLabel1,SLabel2,SLabel3,SLabel4,SLabel5;
	private JComboBox<String> fHeader;
	
	private JTextArea TargetDirectory;
	private JTextField TargetFileFormat;
	private JLabel TLabel2;
	private JLabel TLabel1_1;
	
	private JLabel DQLabel1;
	private JTextField DQCheck;
	private JComboBox<String> dqCheck;
	
	private JLabel FLabel1;
	private JComboBox<String> fNameRequired;
	
	private JLabel TPLabel1,TPLabel2,TPLabel3;
	private JTextField TableName,ClusterColumn,Buckets;
	
	private JTextField Type,UserName;
	private JTextField Password;
	private JTextArea URL,DriverName;
	private JLabel DLabel1,DLabel2,DLabel3,DLabel4,DLabel5;
	
	private JTextField Minimum,Maximum,ParameterName;
	private JLabel DQDLabel1,DQDLabel2,DQDLabel3,wLabel1,wLabel2;
	String DColumn[][]=new String[100][10];
	int Index3=0;
	Font font1 = new Font("Courier", Font.BOLD,16);
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	
	
	private JTextField ColumnName,DataType,Format,FunctionState,Transposable;
	int Index1=0;
	String SColumn[][]=new String[100][10];
	private JLabel CLabel1,CLabel2,CLabel3,CLabel4,CLabel5;
	private JComboBox<String> tPos;
	
	private JTextField rCurrentIndex;
	int Index2=0;
	String RColumn[][]=new String[100][10];
	private JLabel RLabel1;
	
	public void createGUI()
	{     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  double width = screenSize.getWidth();
	      double height = screenSize.getHeight();
		  int w=(int)width;
		  int h=(int)height;
	      mFrame = new JFrame("User Input");
		  mFrame.setSize(w,h);
	      GridLayout gridLayout = new GridLayout(4,4);
	      gridLayout.setVgap(2);
	      gridLayout.setHgap(2);
	      mFrame.getContentPane().setLayout(gridLayout);
	      mFrame.addWindowListener(new WindowAdapter() {
	          public void windowClosing(WindowEvent windowEvent){
	             System.exit(0);
	          }});
	      mFrame.addComponentListener(new ComponentAdapter() {
		        
		         public void componentMoved(ComponentEvent e) {
		            mFrame.setLocation(0,0);
		         }
		      });
	      mFrame.setVisible(true); 
	      
	     /* YES/NO ComboBox */
	      final DefaultComboBoxModel<String> check1 = new DefaultComboBoxModel<String>();
	      check1.addElement("YES");
	      check1.addElement("NO");
	   
	      
	      //Source Components
	      Source=new JPanel();
	      
	      fHeader = new JComboBox<String>(check1);    
	      fHeader.setSelectedIndex(0);
	      
	      Source.setBorder(new TitledBorder(new EtchedBorder(), "Source"));
	      mFrame.getContentPane().add(Source);
	      GridBagConstraints c=new GridBagConstraints();
	      
	      
	       
	      
	      c.fill = GridBagConstraints.HORIZONTAL;  
	      c.weightx = 0.5; 
	      c.insets = new Insets(4,4,4,4);
	      GridBagLayout gbl_Source = new GridBagLayout();
	      gbl_Source.rowHeights = new int[] {10, 10};
	      gbl_Source.columnWidths = new int[] {0, 10, 30, 30};
	      gbl_Source.columnWeights = new double[]{0.0, 0.0};
	      gbl_Source.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	      Source.setLayout(gbl_Source);
	      SLabel1=new JLabel("Source Directory");
	      
	      
	      GridBagConstraints gbc_SLabel1 = new GridBagConstraints();
	      gbc_SLabel1.weightx = 2.0;
	      gbc_SLabel1.anchor = GridBagConstraints.WEST;
	      gbc_SLabel1.insets = new Insets(2, 2, 5, 5);
	      gbc_SLabel1.gridx = 0;
	      gbc_SLabel1.gridy = 0;
	      Source.add(SLabel1, gbc_SLabel1);
	      
	      scrollPane = new JScrollPane();
	      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	      gbc_scrollPane.anchor = GridBagConstraints.WEST;
	      gbc_scrollPane.weightx = 2.0;
	      gbc_scrollPane.insets = new Insets(2, 2, 5, 5);
	      gbc_scrollPane.gridx = 1;
	      gbc_scrollPane.gridy = 0;
	      Source.add(scrollPane, gbc_scrollPane);
	      SourceDirectory=new JTextArea(2,20);
	      scrollPane.setViewportView(SourceDirectory);
	      SLabel3=new JLabel("Source File Type");
	      
	      GridBagConstraints gbc_SLabel3 = new GridBagConstraints();
	      gbc_SLabel3.weightx = 1.0;
	      gbc_SLabel3.anchor = GridBagConstraints.WEST;
	      gbc_SLabel3.insets = new Insets(2, 2, 5, 5);
	      gbc_SLabel3.gridx = 0;
	      gbc_SLabel3.gridy = 2;
	      Source.add(SLabel3, gbc_SLabel3);
	      
	      
	      SourceFileFormat=new JTextField(5);
	      
	      GridBagConstraints gbc_SourceFileFormat = new GridBagConstraints();
	      gbc_SourceFileFormat.weightx = 2.0;
	      gbc_SourceFileFormat.anchor = GridBagConstraints.WEST;
	      gbc_SourceFileFormat.insets = new Insets(2, 2, 5, 5);
	      gbc_SourceFileFormat.gridx = 1;
	      gbc_SourceFileFormat.gridy = 1;
	      Source.add(SourceFileFormat, gbc_SourceFileFormat);
	      SLabel2=new JLabel("Source File Format");
	      GridBagConstraints gbc_SLabel2 = new GridBagConstraints();
	      gbc_SLabel2.weightx = 1.0;
	      gbc_SLabel2.anchor = GridBagConstraints.WEST;
	      gbc_SLabel2.insets = new Insets(2, 2, 5, 5);
	      gbc_SLabel2.gridx = 0;
	      gbc_SLabel2.gridy = 1;
	      Source.add(SLabel2, gbc_SLabel2);
	      SourceFileType=new JTextField(5);
	      
	      GridBagConstraints gbc_SourceFileType = new GridBagConstraints();
	      gbc_SourceFileType.weightx = 2.0;
	      gbc_SourceFileType.anchor = GridBagConstraints.WEST;
	      gbc_SourceFileType.insets = new Insets(2, 2, 5, 5);
	      gbc_SourceFileType.gridx = 1;
	      gbc_SourceFileType.gridy = 2;
	      Source.add(SourceFileType, gbc_SourceFileType);
	      SLabel4=new JLabel("File Header");
	      
	      GridBagConstraints gbc_SLabel4 = new GridBagConstraints();
	      gbc_SLabel4.weightx = 1.0;
	      gbc_SLabel4.anchor = GridBagConstraints.WEST;
	      gbc_SLabel4.insets = new Insets(2, 2, 5, 5);
	      gbc_SLabel4.gridx = 0;
	      gbc_SLabel4.gridy = 3;
	      Source.add(SLabel4, gbc_SLabel4);
	   
	      
	      GridBagConstraints gbc_FileHeader = new GridBagConstraints();
	      gbc_FileHeader.weightx = 2.0;
	      gbc_FileHeader.anchor = GridBagConstraints.WEST;
	      gbc_FileHeader.insets = new Insets(2, 2, 5, 0);
	      gbc_FileHeader.gridx = 1;
	      gbc_FileHeader.gridy = 3;
	      Source.add(fHeader, gbc_FileHeader);
	      SLabel5=new JLabel("Coulumn Delimiter");	     	   
	      
	        GridBagConstraints gbc_SLabel5 = new GridBagConstraints();
	        gbc_SLabel5.weightx = 1.0;
	        gbc_SLabel5.anchor = GridBagConstraints.WEST;
	        gbc_SLabel5.insets = new Insets(2, 2, 2, 5);
	        gbc_SLabel5.gridx = 0;
	        gbc_SLabel5.gridy = 4;
	        Source.add(SLabel5, gbc_SLabel5);
	      ColumnDelimiter=new JTextField(2);
	      
	        GridBagConstraints gbc_ColumnDelimiter = new GridBagConstraints();
	        gbc_ColumnDelimiter.weightx = 2.0;
	        gbc_ColumnDelimiter.insets = new Insets(2, 2, 2, 0);
	        gbc_ColumnDelimiter.anchor = GridBagConstraints.WEST;
	        gbc_ColumnDelimiter.gridx = 1;
	        gbc_ColumnDelimiter.gridy = 4;
	        Source.add(ColumnDelimiter, gbc_ColumnDelimiter);
	      
	     
	      //Target Components
	      Target=new JPanel();
	      TargetFileFormat=new JTextField(5);
	      
	      
	      
	      
	      TLabel2=new JLabel("TargetFileFormat");
	      TLabel1_1=new JLabel("Target Directory");
	      TLabel1_1.setVerticalAlignment(SwingConstants.TOP);
	      TLabel2=new JLabel("Target File Format");
	     
	      GridBagLayout gbl_Target = new GridBagLayout();
	      gbl_Target.rowHeights = new int[] {0};
	      gbl_Target.columnWidths = new int[] {0};
	      Target.setLayout(gbl_Target);
	      
	      mFrame.getContentPane().add(Target);
	      Target.setBorder(new TitledBorder(new EtchedBorder(), "Target"));
	      
	      GridBagConstraints gbc_TLabel1 = new GridBagConstraints();
	      gbc_TLabel1.weightx = 1.0;
	      gbc_TLabel1.anchor = GridBagConstraints.WEST;
	      gbc_TLabel1.insets = new Insets(2, 2, 5, 5);
	      gbc_TLabel1.gridy = 0;
	      gbc_TLabel1.gridx = 0;
	      Target.add(TLabel1_1, gbc_TLabel1);
	      
	      scrollPane_1 = new JScrollPane();
	      scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
	      gbc_scrollPane_1.ipadx = 1;
	      gbc_scrollPane_1.weightx = 1.0;
	      gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
	      gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
	      gbc_scrollPane_1.gridx = 1;
	      gbc_scrollPane_1.gridy = 0;
	      Target.add(scrollPane_1, gbc_scrollPane_1);
	      TargetDirectory=new JTextArea(2,20);
	      scrollPane_1.setViewportView(TargetDirectory);
	      
	      GridBagConstraints gbc_TLabel2 = new GridBagConstraints();
	      gbc_TLabel2.anchor = GridBagConstraints.WEST;
	      gbc_TLabel2.insets = new Insets(2, 2, 2, 5);
	      gbc_TLabel2.gridy = 1;
	      gbc_TLabel2.gridx = 0;
	      Target.add(TLabel2, gbc_TLabel2);
	    
	      GridBagConstraints gbc_TargetFileFormat = new GridBagConstraints();
	      gbc_TargetFileFormat.insets = new Insets(2, 2, 2, 2);
	      gbc_TargetFileFormat.anchor = GridBagConstraints.WEST;
	      gbc_TargetFileFormat.gridy = 1;
	      gbc_TargetFileFormat.gridx = 1;
	      Target.add(TargetFileFormat, gbc_TargetFileFormat);
	      
	      //Data Quality Components
	      final DefaultComboBoxModel<String> check2 = new DefaultComboBoxModel<String>();
	      check2.addElement("YES");
	      check2.addElement("NO");
	      
	      DataQuality=new JPanel();
	      DQCheck=new JTextField(3);
	      DQCheck.setHorizontalAlignment(SwingConstants.LEFT);
	      
	      mFrame.getContentPane().add(DataQuality);
	      DataQuality.setBorder(new TitledBorder(new EtchedBorder(), "Data Quality"));
	      GridBagLayout gbl_DataQuality = new GridBagLayout();
	      gbl_DataQuality.columnWidths = new int[] {0};
	      gbl_DataQuality.rowHeights = new int[] {0};
	      gbl_DataQuality.columnWeights = new double[]{0.0, 0.0};
	      gbl_DataQuality.rowWeights = new double[]{0.0, 0.0};
	      DataQuality.setLayout(gbl_DataQuality);
	      DQLabel1=new JLabel("DQCheck");
	      DQLabel1.setVerticalAlignment(SwingConstants.TOP);
	      DQLabel1.setHorizontalAlignment(SwingConstants.LEFT);
	      GridBagConstraints gbc_DQLabel1 = new GridBagConstraints();
	      gbc_DQLabel1.anchor = GridBagConstraints.WEST;
	      gbc_DQLabel1.weightx = 1.0;
	      gbc_DQLabel1.gridx = 0;
	      gbc_DQLabel1.gridy = 1;
	      DataQuality.add(DQLabel1, gbc_DQLabel1);
	      
	      dqCheck = new JComboBox<String>(check2);
	      dqCheck.setMaximumRowCount(2);
	      dqCheck.setSelectedIndex(0);
	      GridBagConstraints gbc_dqCheck = new GridBagConstraints();
	      gbc_dqCheck.insets = new Insets(2, 2, 5, 5);
	      gbc_dqCheck.weightx = 2.0;
	      gbc_dqCheck.anchor = GridBagConstraints.WEST;
	      gbc_dqCheck.gridx = 1;
	      gbc_dqCheck.gridy = 1;
	      DataQuality.add(dqCheck, gbc_dqCheck);
	    
	      GridBagConstraints gbc_DQCheck = new GridBagConstraints();
	      gbc_DQCheck.insets = new Insets(2, 2, 2, 2);
	      gbc_DQCheck.anchor = GridBagConstraints.WEST;
	      gbc_DQCheck.gridy = 0;
	      gbc_DQCheck.gridx = 1;
	      
	      
	      
	      //File Name Components
	      FileName=new JPanel();
	      final DefaultComboBoxModel<String> check3 = new DefaultComboBoxModel<String>();
	      check3.addElement("YES");
	      check3.addElement("NO");
	      
	      mFrame.getContentPane().add(FileName);
	      FileName.setBorder(new TitledBorder(new EtchedBorder(), "File Name"));
	       GridBagLayout gbl_FileName = new GridBagLayout();
	       gbl_FileName.columnWidths = new int[] {0, 30, 30, 0};
	       gbl_FileName.rowHeights = new int[] {10, 10};
	       gbl_FileName.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0};
	       gbl_FileName.rowWeights = new double[]{0.0, 0.0};
	       FileName.setLayout(gbl_FileName);
	       fNameRequired = new JComboBox<String>(check3);
	       fNameRequired.setSelectedIndex(0);
	       GridBagConstraints gbc_fNameRequired = new GridBagConstraints();
	       gbc_fNameRequired.weightx = 0.12;
	       gbc_fNameRequired.insets = new Insets(2, 2, 5, 5);
	       gbc_fNameRequired.anchor = GridBagConstraints.WEST;
	       gbc_fNameRequired.gridx = 4;
	       gbc_fNameRequired.gridy = 1;
	       FileName.add(fNameRequired, gbc_fNameRequired);
	      
	       FLabel1=new JLabel("File Name Required");
	       GridBagConstraints gbc_FLabel1 = new GridBagConstraints();
	       gbc_FLabel1.insets = new Insets(2, 2, 5, 5);
	       gbc_FLabel1.anchor = GridBagConstraints.WEST;
	       gbc_FLabel1.fill = GridBagConstraints.BOTH;
	       gbc_FLabel1.gridx = 1;
	       gbc_FLabel1.gridy = 1;
	       FileName.add(FLabel1, gbc_FLabel1);
	      
	      //Table Properties Components
	      TableProperties=new JPanel();
	     
	      mFrame.getContentPane().add(TableProperties);
	      TableProperties.setBorder(new TitledBorder(new EtchedBorder(), "Table Properties"));
	      GridBagLayout gbl_TableProperties = new GridBagLayout();
	      gbl_TableProperties.columnWidths = new int[]{50, 250, 0, 0};
	      gbl_TableProperties.rowHeights = new int[]{50, 20, 20, 20, 0};
	      gbl_TableProperties.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	      gbl_TableProperties.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	      TableProperties.setLayout(gbl_TableProperties);
	      TPLabel1=new JLabel("Table Name");
	      GridBagConstraints gbc_TPLabel1 = new GridBagConstraints();
	      gbc_TPLabel1.anchor = GridBagConstraints.WEST;
	      gbc_TPLabel1.fill = GridBagConstraints.VERTICAL;
	      gbc_TPLabel1.insets = new Insets(0, 0, 5, 0);
	      gbc_TPLabel1.gridx = 0;
	      gbc_TPLabel1.gridy = 1;
	      TableProperties.add(TPLabel1, gbc_TPLabel1);
	      TableName=new JTextField(15);
	      GridBagConstraints gbc_TableName = new GridBagConstraints();
	      gbc_TableName.anchor = GridBagConstraints.NORTHEAST;
	      gbc_TableName.insets = new Insets(2, 2, 5, 5);
	      gbc_TableName.gridx = 1;
	      gbc_TableName.gridy = 1;
	      TableProperties.add(TableName, gbc_TableName);
	      TPLabel2=new JLabel("Cluster Column");
	      GridBagConstraints gbc_TPLabel2 = new GridBagConstraints();
	      gbc_TPLabel2.anchor = GridBagConstraints.WEST;
	      gbc_TPLabel2.fill = GridBagConstraints.VERTICAL;
	      gbc_TPLabel2.insets = new Insets(0, 0, 5, 0);
	      gbc_TPLabel2.gridx = 0;
	      gbc_TPLabel2.gridy = 2;
	      TableProperties.add(TPLabel2, gbc_TPLabel2);
	      ClusterColumn=new JTextField(15);
	      GridBagConstraints gbc_ClusterColumn = new GridBagConstraints();
	      gbc_ClusterColumn.anchor = GridBagConstraints.NORTHEAST;
	      gbc_ClusterColumn.insets = new Insets(2, 2, 5, 5);
	      gbc_ClusterColumn.gridx = 1;
	      gbc_ClusterColumn.gridy = 2;
	      TableProperties.add(ClusterColumn, gbc_ClusterColumn);
	      Buckets=new JTextField(15);
	      GridBagConstraints gbc_Buckets = new GridBagConstraints();
	      gbc_Buckets.anchor = GridBagConstraints.SOUTHEAST;
	      gbc_Buckets.insets = new Insets(2, 2, 5, 5);
	      gbc_Buckets.gridx = 1;
	      gbc_Buckets.gridy = 3;
	      TableProperties.add(Buckets, gbc_Buckets);
	      TPLabel3=new JLabel("Buckets");
	      GridBagConstraints gbc_TPLabel3 = new GridBagConstraints();
	      gbc_TPLabel3.fill = GridBagConstraints.VERTICAL;
	      gbc_TPLabel3.anchor = GridBagConstraints.WEST;
	      gbc_TPLabel3.gridx = 0;
	      gbc_TPLabel3.gridy = 3;
	      TableProperties.add(TPLabel3, gbc_TPLabel3);
	      
	      //DataBase Components
	      DataBase=new JPanel();
	      DataBase.setLayout(new GridBagLayout());
	      Type=new JTextField(10);
	      UserName=new JTextField(15);
	      Password=new JPasswordField(15);
	      DLabel1=new JLabel("Type");
	      DLabel2=new JLabel("URL");
	      DLabel3=new JLabel("User Name");
	      DLabel4=new JLabel("Password");
	      DLabel5=new JLabel("Driver Name");
	      
	      mFrame.getContentPane().add(DataBase);
	      DataBase.setBorder(new TitledBorder(new EtchedBorder(), "DataBase"));
	      GridBagConstraints gbc_DLabel1 = new GridBagConstraints();
	      gbc_DLabel1.weightx = 1.0;
	      gbc_DLabel1.insets = new Insets(2, 2, 5, 5);
	      gbc_DLabel1.gridy = 0;
	      gbc_DLabel1.gridx = 0;
	      gbc_DLabel1.anchor = GridBagConstraints.WEST;
	      DataBase.add(DLabel1, gbc_DLabel1);
	      GridBagConstraints gbc_Type = new GridBagConstraints();
	      gbc_Type.weightx = 2.0;
	      gbc_Type.anchor = GridBagConstraints.WEST;
	      gbc_Type.gridy = 0;
	      gbc_Type.gridx = 1;
	      gbc_Type.insets = new Insets(2, 2, 5, 2);
	      DataBase.add(Type, gbc_Type);
	      GridBagConstraints gbc_DLabel2 = new GridBagConstraints();
	      gbc_DLabel2.anchor = GridBagConstraints.WEST;
	      gbc_DLabel2.gridy = 1;
	      gbc_DLabel2.gridx = 0;
	      gbc_DLabel2.insets = new Insets(2, 2, 5, 5);
	      DataBase.add(DLabel2, gbc_DLabel2);
	      
	      scrollPane_2 = new JScrollPane();
	      scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
	      gbc_scrollPane_2.anchor = GridBagConstraints.WEST;
	      gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
	      gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
	      gbc_scrollPane_2.gridx = 1;
	      gbc_scrollPane_2.gridy = 1;
	      DataBase.add(scrollPane_2, gbc_scrollPane_2);
	      URL=new JTextArea(2,20);
	      scrollPane_2.setViewportView(URL);
	      GridBagConstraints gbc_DLabel3 = new GridBagConstraints();
	      gbc_DLabel3.anchor = GridBagConstraints.WEST;
	      gbc_DLabel3.gridx = 0;
	      gbc_DLabel3.gridy = 2;
	      gbc_DLabel3.insets = new Insets(2, 2, 5, 5);
	      DataBase.add(DLabel3, gbc_DLabel3);
	      GridBagConstraints gbc_UserName = new GridBagConstraints();
	      gbc_UserName.anchor = GridBagConstraints.WEST;
	      gbc_UserName.gridx = 1;
	      gbc_UserName.gridy = 2;
	      gbc_UserName.insets = new Insets(2, 2, 5, 2);
	      DataBase.add(UserName, gbc_UserName);
	      GridBagConstraints gbc_DLabel4 = new GridBagConstraints();
	      gbc_DLabel4.anchor = GridBagConstraints.WEST;
	      gbc_DLabel4.gridx = 0;
	      gbc_DLabel4.gridy = 3;
	      gbc_DLabel4.insets = new Insets(2, 2, 5, 5);
	      DataBase.add(DLabel4, gbc_DLabel4);
	      GridBagConstraints gbc_Password = new GridBagConstraints();
	      gbc_Password.anchor = GridBagConstraints.WEST;
	      gbc_Password.gridy = 3;
	      gbc_Password.gridx = 1;
	      gbc_Password.insets = new Insets(2, 2, 5, 2);
	      DataBase.add(Password, gbc_Password);
	      GridBagConstraints gbc_DLabel5 = new GridBagConstraints();
	      gbc_DLabel5.anchor = GridBagConstraints.WEST;
	      gbc_DLabel5.gridx = 0;
	      gbc_DLabel5.gridy = 4;
	      gbc_DLabel5.insets = new Insets(2, 2, 2, 5);
	      DataBase.add(DLabel5, gbc_DLabel5);
	      
	      scrollPane_3 = new JScrollPane();
	      scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
	      gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
	      gbc_scrollPane_3.gridx = 1;
	      gbc_scrollPane_3.gridy = 4;
	      DataBase.add(scrollPane_3, gbc_scrollPane_3);
	      DriverName=new JTextArea(2,15);
	      scrollPane_3.setViewportView(DriverName);
	      
	      //DQData Components
	      DQData=new JPanel();
	      GridBagLayout gbl_DQData = new GridBagLayout();
	      gbl_DQData.columnWidths = new int[] {0};
	      gbl_DQData.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
	      gbl_DQData.columnWeights = new double[]{0.0, 0.0, 0.0};
	      gbl_DQData.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	      DQData.setLayout(gbl_DQData);
	      Minimum=new JTextField(15);
	      GridBagConstraints gbc_Minimum = new GridBagConstraints();
	      gbc_Minimum.weightx = 1.0;
	      gbc_Minimum.anchor = GridBagConstraints.WEST;
	      gbc_Minimum.insets = new Insets(2, 2, 5, 5);
	      gbc_Minimum.gridx = 1;
	      gbc_Minimum.gridy = 1;
	      DQData.add(Minimum, gbc_Minimum);
	      DQDLabel1=new JLabel("Minimum");
	      GridBagConstraints gbc_DQDLabel1 = new GridBagConstraints();
	      gbc_DQDLabel1.weightx = 0.5;
	      gbc_DQDLabel1.anchor = GridBagConstraints.EAST;
	      gbc_DQDLabel1.fill = GridBagConstraints.BOTH;
	      gbc_DQDLabel1.insets = new Insets(2, 2, 5, 5);
	      gbc_DQDLabel1.gridx = 0;
	      gbc_DQDLabel1.gridy = 1;
	      DQData.add(DQDLabel1, gbc_DQDLabel1);
	      wLabel1=new JLabel("");
	      wLabel1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
	      GridBagConstraints gbc_wLabel1 = new GridBagConstraints();
	      gbc_wLabel1.anchor = GridBagConstraints.WEST;
	      gbc_wLabel1.weightx = 0.5;
	      gbc_wLabel1.fill = GridBagConstraints.BOTH;
	      gbc_wLabel1.insets = new Insets(0, 0, 5, 0);
	      gbc_wLabel1.gridx = 2;
	      gbc_wLabel1.gridy = 1;
	      DQData.add(wLabel1, gbc_wLabel1);
	      DQDLabel2=new JLabel("Maximum");
	      GridBagConstraints gbc_DQDLabel2 = new GridBagConstraints();
	      gbc_DQDLabel2.anchor = GridBagConstraints.EAST;
	      gbc_DQDLabel2.weightx = 0.5;
	      gbc_DQDLabel2.fill = GridBagConstraints.BOTH;
	      gbc_DQDLabel2.insets = new Insets(2, 2, 5, 5);
	      gbc_DQDLabel2.gridx = 0;
	      gbc_DQDLabel2.gridy = 2;
	      DQData.add(DQDLabel2, gbc_DQDLabel2);
	      Maximum=new JTextField(15);
	      GridBagConstraints gbc_Maximum = new GridBagConstraints();
	      gbc_Maximum.weightx = 1.0;
	      gbc_Maximum.anchor = GridBagConstraints.WEST;
	      gbc_Maximum.insets = new Insets(2, 2, 5, 5);
	      gbc_Maximum.gridx = 1;
	      gbc_Maximum.gridy = 2;
	      DQData.add(Maximum, gbc_Maximum);
	      wLabel2=new JLabel("");
	      wLabel2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
	      GridBagConstraints gbc_wLabel2 = new GridBagConstraints();
	      gbc_wLabel2.anchor = GridBagConstraints.WEST;
	      gbc_wLabel2.weightx = 0.5;
	      gbc_wLabel2.fill = GridBagConstraints.BOTH;
	      gbc_wLabel2.insets = new Insets(2, 2, 5, 5);
	      gbc_wLabel2.gridx = 2;
	      gbc_wLabel2.gridy = 2;
	      DQData.add(wLabel2, gbc_wLabel2);
	      DQDLabel3=new JLabel("Parameter Name");
	      GridBagConstraints gbc_DQDLabel3 = new GridBagConstraints();
	      gbc_DQDLabel3.weightx = 0.5;
	      gbc_DQDLabel3.anchor = GridBagConstraints.WEST;
	      gbc_DQDLabel3.fill = GridBagConstraints.VERTICAL;
	      gbc_DQDLabel3.insets = new Insets(2, 2, 5, 5);
	      gbc_DQDLabel3.gridx = 0;
	      gbc_DQDLabel3.gridy = 3;
	      DQData.add(DQDLabel3, gbc_DQDLabel3);
	      ParameterName=new JTextField(15);
	      GridBagConstraints gbc_ParameterName = new GridBagConstraints();
	      gbc_ParameterName.anchor = GridBagConstraints.WEST;
	      gbc_ParameterName.insets = new Insets(2, 2, 5, 5);
	      gbc_ParameterName.gridx = 1;
	      gbc_ParameterName.gridy = 3;
	      DQData.add(ParameterName, gbc_ParameterName);
	      
	      JButton dAdd=new JButton("Add");
	      JButton dView=new JButton("View");
	      dAdd.addActionListener(new DAddClickListener());
	      dView.addActionListener(new DViewClickListener());
	      DQData.setBorder(new TitledBorder(new EtchedBorder(), "DQData"));
	      GridBagConstraints gbc_dAdd = new GridBagConstraints();
	      gbc_dAdd.insets = new Insets(2, 2, 5, 5);
	      gbc_dAdd.anchor = GridBagConstraints.WEST;
	      gbc_dAdd.weightx = 0.25;
	      gbc_dAdd.gridx = 1;
	      gbc_dAdd.gridy = 4;
	      DQData.add(dAdd, gbc_dAdd);
	      GridBagConstraints gbc_dView = new GridBagConstraints();
	      gbc_dView.insets = new Insets(2, 2, 5, 5);
	      gbc_dView.anchor = GridBagConstraints.WEST;
	      gbc_dView.weightx = 0.25;
	      gbc_dView.gridx = 1;
	      gbc_dView.gridy = 5;
	      DQData.add(dView, gbc_dView);
	      mFrame.getContentPane().add(DQData);
	      DQData.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{DQDLabel1, Minimum, wLabel1, DQDLabel2, Maximum, wLabel2, DQDLabel3, ParameterName}));
	      //ColumnMetaData Components
	      ColumnMetaData=new JPanel();
	      
	      final DefaultComboBoxModel<String> check4 = new DefaultComboBoxModel<String>();
	      check4.addElement("YES");
	      check4.addElement("NO");
	      
	      tPos = new JComboBox<String>(check4);    
	      tPos.setSelectedIndex(0);
	      
	      mFrame.getContentPane().add(ColumnMetaData);
	      ColumnMetaData.setBorder(new TitledBorder(new EtchedBorder(), "Column MetaData"));
	      GridBagLayout gbl_ColumnMetaData = new GridBagLayout();
	      gbl_ColumnMetaData.columnWidths = new int[] {0, 0, 0, 0, 0};
	      gbl_ColumnMetaData.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
	      gbl_ColumnMetaData.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	      gbl_ColumnMetaData.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	      ColumnMetaData.setLayout(gbl_ColumnMetaData);     
	      Transposable=new JTextField(4);
	      GridBagConstraints gbc_Transposable = new GridBagConstraints();
	      gbc_Transposable.anchor = GridBagConstraints.WEST;
	      gbc_Transposable.fill = GridBagConstraints.BOTH;
	      gbc_Transposable.insets = new Insets(2, 2, 2, 2);
	      gbc_Transposable.gridx = 1;
	      gbc_Transposable.gridy = 4;
	      ColumnMetaData.add(tPos, gbc_Transposable);
	      CLabel5=new JLabel("Transposable");
	      GridBagConstraints gbc_CLabel5 = new GridBagConstraints();
	      gbc_CLabel5.anchor = GridBagConstraints.WEST;
	      gbc_CLabel5.fill = GridBagConstraints.BOTH;
	      gbc_CLabel5.insets = new Insets(2, 2, 2, 2);
	      gbc_CLabel5.gridx = 0;
	      gbc_CLabel5.gridy = 4;
	      ColumnMetaData.add(CLabel5, gbc_CLabel5);
	      FunctionState=new JTextField(15);
	      GridBagConstraints gbc_FunctionState = new GridBagConstraints();
	      gbc_FunctionState.anchor = GridBagConstraints.WEST;
	      gbc_FunctionState.fill = GridBagConstraints.BOTH;
	      gbc_FunctionState.insets = new Insets(2, 2, 2, 2);
	      gbc_FunctionState.gridx = 1;
	      gbc_FunctionState.gridy = 3;
	      ColumnMetaData.add(FunctionState, gbc_FunctionState);
	      CLabel4=new JLabel("Function State");
	      GridBagConstraints gbc_CLabel4 = new GridBagConstraints();
	      gbc_CLabel4.anchor = GridBagConstraints.WEST;
	      gbc_CLabel4.fill = GridBagConstraints.BOTH;
	      gbc_CLabel4.insets = new Insets(2, 2, 2, 2);
	      gbc_CLabel4.gridx = 0;
	      gbc_CLabel4.gridy = 3;
	      ColumnMetaData.add(CLabel4, gbc_CLabel4);
	      Format=new JTextField(10);
	      GridBagConstraints gbc_Format = new GridBagConstraints();
	      gbc_Format.anchor = GridBagConstraints.WEST;
	      gbc_Format.fill = GridBagConstraints.BOTH;
	      gbc_Format.insets = new Insets(2, 2, 2, 2);
	      gbc_Format.gridx = 1;
	      gbc_Format.gridy = 2;
	      ColumnMetaData.add(Format, gbc_Format);
	      CLabel3=new JLabel("Format");
	      GridBagConstraints gbc_CLabel3 = new GridBagConstraints();
	      gbc_CLabel3.anchor = GridBagConstraints.WEST;
	      gbc_CLabel3.fill = GridBagConstraints.BOTH;
	      gbc_CLabel3.insets = new Insets(2, 2, 2, 2);
	      gbc_CLabel3.gridx = 0;
	      gbc_CLabel3.gridy = 2;
	      ColumnMetaData.add(CLabel3, gbc_CLabel3);
	      DataType=new JTextField(10);
	      GridBagConstraints gbc_DataType = new GridBagConstraints();
	      gbc_DataType.anchor = GridBagConstraints.WEST;
	      gbc_DataType.fill = GridBagConstraints.BOTH;
	      gbc_DataType.insets = new Insets(2, 2, 2, 2);
	      gbc_DataType.gridx = 1;
	      gbc_DataType.gridy = 1;
	      ColumnMetaData.add(DataType, gbc_DataType);
	      CLabel2=new JLabel("Data Type");
	      GridBagConstraints gbc_CLabel2 = new GridBagConstraints();
	      gbc_CLabel2.anchor = GridBagConstraints.WEST;
	      gbc_CLabel2.fill = GridBagConstraints.BOTH;
	      gbc_CLabel2.insets = new Insets(2, 2, 2, 2);
	      gbc_CLabel2.gridx = 0;
	      gbc_CLabel2.gridy = 1;
	      ColumnMetaData.add(CLabel2, gbc_CLabel2);
	      
	      ColumnName=new JTextField(15);
	      GridBagConstraints gbc_ColumnName = new GridBagConstraints();
	      gbc_ColumnName.weightx = 0.5;
	      gbc_ColumnName.anchor = GridBagConstraints.WEST;
	      gbc_ColumnName.fill = GridBagConstraints.BOTH;
	      gbc_ColumnName.insets = new Insets(2, 2, 2, 2);
	      gbc_ColumnName.gridx = 1;
	      gbc_ColumnName.gridy = 0;
	      ColumnMetaData.add(ColumnName, gbc_ColumnName);
	      CLabel1=new JLabel("Column Name");
	      
	      GridBagConstraints gbc_CLabel1 = new GridBagConstraints();
	      gbc_CLabel1.weightx = 0.25;
	      gbc_CLabel1.insets = new Insets(2, 2, 2, 2);
	      gbc_CLabel1.anchor = GridBagConstraints.WEST;
	      gbc_CLabel1.gridwidth = 2;
	      gbc_CLabel1.fill = GridBagConstraints.BOTH;
	      gbc_CLabel1.gridx = 0;
	      gbc_CLabel1.gridy = 0;
	      ColumnMetaData.add(CLabel1, gbc_CLabel1);
	      JButton Add=new JButton("Add");
	      Add.setActionCommand("Add");
	      GridBagConstraints gbc_Add = new GridBagConstraints();
	      gbc_Add.insets = new Insets(2, 2, 2, 2);
	      gbc_Add.gridx = 3;
	      gbc_Add.gridy = 5;
	      ColumnMetaData.add(Add, gbc_Add);
	      Add.addActionListener(new AddClickListener());
	      JButton viewButton=new JButton("View");
	      viewButton.setActionCommand("View");
	      viewButton.addActionListener(new viewClickListener());
	   	   
	      GridBagConstraints gbc_viewButton = new GridBagConstraints();
	      gbc_viewButton.insets = new Insets(2, 2, 2, 2);
	      gbc_viewButton.gridx = 4;
	      gbc_viewButton.gridy = 5;
	      ColumnMetaData.add(viewButton, gbc_viewButton);
	      
	     
	      //RequiredColumns Components
	      RequiredColumns=new JPanel();
	      mFrame.getContentPane().add(RequiredColumns);
	      RequiredColumns.setBorder(new TitledBorder(new EtchedBorder(), "Required Columns"));
	      GridBagLayout gbl_RequiredColumns = new GridBagLayout();
	      gbl_RequiredColumns.columnWidths = new int[]{50, 150, 100, 0};
	      gbl_RequiredColumns.rowHeights = new int[]{75, 20, 20, 0};
	      gbl_RequiredColumns.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	      gbl_RequiredColumns.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	      RequiredColumns.setLayout(gbl_RequiredColumns);
	      RLabel1=new JLabel("Current Index");
	      GridBagConstraints gbc_RLabel1 = new GridBagConstraints();
	      gbc_RLabel1.weightx = 0.25;
	      gbc_RLabel1.anchor = GridBagConstraints.WEST;
	      gbc_RLabel1.fill = GridBagConstraints.BOTH;
	      gbc_RLabel1.insets = new Insets(2, 2, 5, 5);
	      gbc_RLabel1.gridx = 0;
	      gbc_RLabel1.gridy = 1;
	      RequiredColumns.add(RLabel1, gbc_RLabel1);
	      rCurrentIndex=new JTextField(2);
	      GridBagConstraints gbc_rCurrentIndex = new GridBagConstraints();
	      gbc_rCurrentIndex.weightx = 0.25;
	      gbc_rCurrentIndex.anchor = GridBagConstraints.WEST;
	      gbc_rCurrentIndex.insets = new Insets(0, 0, 5, 5);
	      gbc_rCurrentIndex.gridx = 1;
	      gbc_rCurrentIndex.gridy = 1;
	      RequiredColumns.add(rCurrentIndex, gbc_rCurrentIndex);
	      
	         JButton rAdd=new JButton("Add");
	         rAdd.addActionListener(new rAddClickListener());
	         GridBagConstraints gbc_rAdd = new GridBagConstraints();
	         gbc_rAdd.fill = GridBagConstraints.BOTH;
	         gbc_rAdd.insets = new Insets(0, 0, 5, 0);
	         gbc_rAdd.gridx = 2;
	         gbc_rAdd.gridy = 1;
	         RequiredColumns.add(rAdd, gbc_rAdd);
	      JButton rviewButton=new JButton("View");
	      rviewButton.addActionListener(new RviewActionListener());
	      GridBagConstraints gbc_rviewButton = new GridBagConstraints();
	      gbc_rviewButton.fill = GridBagConstraints.BOTH;
	      gbc_rviewButton.gridx = 2;
	      gbc_rviewButton.gridy = 2;
	      RequiredColumns.add(rviewButton, gbc_rviewButton);
	      
	      
	      
	      //SubmitButton
	      SPanel=new JPanel();
	      
	      JButton Submit=new JButton("Submit");
		  Submit.setActionCommand("Submit");
		  Submit.addActionListener(new ButtonClickListener());
		  SPanel.add(Submit);
		  mFrame.setVisible(true);
		  
		  
		  //Extra
		  TPanel=new JPanel();
		  EPanel=new JPanel();
		  mFrame.getContentPane().add(TPanel);
		  mFrame.getContentPane().add(SPanel);
		  mFrame.getContentPane().add(EPanel);
	    }
	
		
	/* Creating the XML Document */
   public class ButtonClickListener implements ActionListener
   {   String Input1,Input2;
	 //Method for verifying the Input Fields 
    
      public void actionPerformed(ActionEvent ae)
	   {   
		   		   
		   String command=ae.getActionCommand();
		   if(command.equals("Submit"))
		   {  
			  try
			  {
				  			 DocumentBuilderFactory dbFactory =
					         DocumentBuilderFactory.newInstance();
					         DocumentBuilder dBuilder =dbFactory.newDocumentBuilder(); 
					            
					         Document doc = dBuilder.newDocument();
					        
					         //Root element
					         Element rootElement = doc.createElement("metadata");
					         doc.appendChild(rootElement);

					         //Source
					         Element source = doc.createElement("Source");
					         rootElement.appendChild(source);
					         Element sourcedirectory=doc.createElement("SourceDirectory");
					         source.appendChild(sourcedirectory);
					         sourcedirectory.appendChild(doc.createTextNode(SourceDirectory.getText()));
					         Element sourcefileformat=doc.createElement("SourceFileFormat");
					         source.appendChild(sourcefileformat);
					         sourcefileformat.appendChild(doc.createTextNode(SourceFileFormat.getText()));
					         Element sourcefiletype=doc.createElement("SourceFileType");
					         source.appendChild(sourcefiletype);
					         sourcefiletype.appendChild(doc.createTextNode(SourceFileType.getText()));
					         Element fileheader=doc.createElement("FileHeader");
					         source.appendChild(fileheader);
					         fileheader.appendChild(doc.createTextNode((String)fHeader.getSelectedItem()));
					         Element columndelimiter=doc.createElement("ColumnDelimiter");
					         source.appendChild(columndelimiter);
					         columndelimiter.appendChild(doc.createTextNode(ColumnDelimiter.getText()));
					         
					         
					         //Target
					         Element target=doc.createElement("Target");
					         rootElement.appendChild(target);
					         Element targetdirectory=doc.createElement("TargetDirectory");
					         target.appendChild(targetdirectory);
					         targetdirectory.appendChild(doc.createTextNode(TargetDirectory.getText()));
					         Element targetfileformat=doc.createElement("TargetFileFormat");
					         target.appendChild(targetfileformat);
					         targetfileformat.appendChild(doc.createTextNode(TargetFileFormat.getText()));
					  
                                 
					         //DataQuality
					         Element dataquality=doc.createElement("DataQuality");
					         rootElement.appendChild(dataquality);
					         Element dqcheck=doc.createElement("DQCheck");
					         dataquality.appendChild(dqcheck);
					         dqcheck.appendChild(doc.createTextNode((String)dqCheck.getSelectedItem()));
					         
					         //File Name
					         Element filename=doc.createElement("FileName");
					         rootElement.appendChild(filename);
					         Element filenamerequired=doc.createElement("FileNameRequired");
					         filename.appendChild(filenamerequired);
					         filenamerequired.appendChild(doc.createTextNode((String)fNameRequired.getSelectedItem()));
					         
					         
					         //Table Properties
					         Element tableproperties=doc.createElement("TableProperties");
					         rootElement.appendChild(tableproperties);
					         Element tablename=doc.createElement("TableName");
					         tableproperties.appendChild(tablename);
					         tablename.appendChild(doc.createTextNode(TableName.getText()));
					         Element clustercolumn=doc.createElement("ClusterColumn");
					         tableproperties.appendChild(clustercolumn);
					         clustercolumn.appendChild(doc.createTextNode(ClusterColumn.getText()));
					         Element buckets=doc.createElement("Buckets");
					         tableproperties.appendChild(buckets);
					         buckets.appendChild(doc.createTextNode(Buckets.getText()));
					         
					         //DataBase
					         Element database=doc.createElement("DataBase");
					         rootElement.appendChild(database);
					         Element type=doc.createElement("Type");
					         database.appendChild(type);
					         type.appendChild(doc.createTextNode(Type.getText()));
					         Element url=doc.createElement("URL");
					         database.appendChild(url);
					         url.appendChild(doc.createTextNode(URL.getText()));
					         Element username=doc.createElement("UserName");
					         database.appendChild(username);
					         username.appendChild(doc.createTextNode(UserName.getText()));
					         Element password=doc.createElement("Password");
					         database.appendChild(password);
					         password.appendChild(doc.createTextNode(Password.getText()));
					         Element drivername=doc.createElement("DriverName");
					         database.appendChild(drivername);
					         drivername.appendChild(doc.createTextNode(DriverName.getText()));
					         
					         //DQData
					         Element dqdata=doc.createElement("DQData");
					         rootElement.appendChild(dqdata);
					         Element col2,minimum,maximum,parametername;
					         for(int i=0;i<Index3;i++)
					         {
					        	 col2=doc.createElement("Column");
					        	 dqdata.appendChild(col2);
					        	 minimum=doc.createElement("Minimum");
					        	 col2.appendChild(minimum);
					        	 minimum.appendChild(doc.createTextNode(DColumn[i][0]));
					        	 maximum=doc.createElement("Maximum");
					        	 col2.appendChild(maximum);
					        	 maximum.appendChild(doc.createTextNode(DColumn[i][1]));
					        	 parametername=doc.createElement("ParameterName");
					        	 col2.appendChild(parametername);
					        	 parametername.appendChild(doc.createTextNode(DColumn[i][2]));
					        	 
					         }
					         
					         //	ColumnMetaData
					         Element columnmetadata=doc.createElement("ColumnMetaDeta");
					         rootElement.appendChild(columnmetadata);
					         Element col,index,columnname,datatype,format,functionstate,transposable;
					         for(int i=0;i<Index1;i++)
					         {
					        	 col=doc.createElement("Column");
					        	 columnmetadata.appendChild(col);
					        	 index=doc.createElement("Index");
					        	 col.appendChild(index);
					        	 index.appendChild(doc.createTextNode(Integer.toString(i)));
					        	 columnname=doc.createElement("ColumnName");
					        	 col.appendChild(columnname);
					        	 columnname.appendChild(doc.createTextNode(SColumn[i][0]));
					        	 datatype=doc.createElement("DataType");
					        	 col.appendChild(datatype);
					        	 datatype.appendChild(doc.createTextNode(SColumn[i][1]));
					        	 format=doc.createElement("Format");
					        	 col.appendChild(format);
					        	 format.appendChild(doc.createTextNode(SColumn[i][2]));
					        	 functionstate=doc.createElement("FunctionState");
					        	 col.appendChild(functionstate);
					        	 functionstate.appendChild(doc.createTextNode(SColumn[i][3]));
					        	 transposable=doc.createElement("Transposable");
					        	 col.appendChild(transposable);
					        	 transposable.appendChild(doc.createTextNode(SColumn[i][4]));
					         } 
					         //Required Columns
					         Element requiredcolumns=doc.createElement("RequiredColumns");
					         rootElement.appendChild(requiredcolumns);
					         Element col1,rIndex,rCurIndex,rColName,rDType,rFrmt;
					         for(int j=0;j<Index2;j++)
					         {
					        	 col1=doc.createElement("Column");
					        	 requiredcolumns.appendChild(col1);
					        	 rIndex=doc.createElement("Index");
					        	 col1.appendChild(rIndex);
					        	 rIndex.appendChild(doc.createTextNode(Integer.toString(j)));
					        	 rCurIndex=doc.createElement("CurrentIndex");
					        	 col1.appendChild(rCurIndex);
					        	 rCurIndex.appendChild(doc.createTextNode(RColumn[j][0]));
					        	 rColName=doc.createElement("ColumnName");
					        	 col1.appendChild(rColName);
					        	 rColName.appendChild(doc.createTextNode(RColumn[j][1]));
					        	 rDType=doc.createElement("DataType");
					        	 col1.appendChild(rDType);
					        	 rDType.appendChild(doc.createTextNode(RColumn[j][2]));
					        	 rFrmt=doc.createElement("Format");
					        	 col1.appendChild(rFrmt);
					        	 rFrmt.appendChild(doc.createTextNode(RColumn[j][3]));
					        	 					        			 
					         }
					         
					         
					         
	  				         // To write the contents into XML File
					         TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
					         Transformer transformer =transformerFactory.newTransformer();
					         
					         DOMSource Source = new DOMSource(doc);
					         StreamResult result =
					         new StreamResult(new File("C:\\Users\\TR100081\\eclipse-workspace\\XML\\metadata.xml"));
					         transformer.transform(Source, result);       
					         
					         
					         
				  
				  
			  }catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			   
			  
		   }
		 
		      
			   
		   
		   
	   }
   }
   
  /* Adding Meta Data Columns */ 
 public class AddClickListener implements ActionListener
   { public void actionPerformed(ActionEvent ae1)
	   {
	   
	 	  createMetaDataColumns(); 
	   }
	   
   }
 
 public void createMetaDataColumns()
 {
	   SColumn[Index1][0]=new String(ColumnName.getText());	   
	   SColumn[Index1][1]=new String(DataType.getText());
	   SColumn[Index1][2]=new String(Format.getText());
	   SColumn[Index1][3]=new String(FunctionState.getText());
	   SColumn[Index1][4]=new String((String)tPos.getSelectedItem());
	   ColumnName.setText("");	    
	   DataType.setText("");
	   Format.setText("");
	   FunctionState.setText("");
	   Transposable.setText("");
	   ColumnMetaData.revalidate();
	   ColumnMetaData.repaint();
	   Index1++;
 }
  
 /*Adding Required Data Columns*/
 public class rAddClickListener implements ActionListener
 { public void actionPerformed(ActionEvent ae1)
	   {
	   
	 	  createRequiredDataColumns(); 
	   }
	   
 }
 public void createRequiredDataColumns()
 {     
	   //Checking whether the required index exist or whether it is already added to the required column list	   
 	   int flag=0;
 	   flag=tCheck.NumCheck(rCurrentIndex.getText());
 	   if(flag==-1)
 	   {
 		   JOptionPane.showConfirmDialog(null,"Incorrect Index","Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
		   rCurrentIndex.setText("");
		   return;  
 	   }
 	   flag=0;
 	   int i=Integer.parseInt(rCurrentIndex.getText());
	   for(int k=0;k<Index1;k++)
	   {
		   if(i==k)
		   {
			   flag=1; break;
		   }
	   }
	   if(flag==0)
	   {
		   JOptionPane.showConfirmDialog(null,"Incorrect Index","Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
		   rCurrentIndex.setText("");
		   return;
	   }
	   flag=0;
	   for(int l=0;l<Index2;l++)
	   {
		   if(i==Integer.parseInt(RColumn[l][0]))
		   {
			   flag=1; break;
		   }
	   }
	   if(flag==1)
	   {
		   JOptionPane.showConfirmDialog(null,"Index Already Exists","Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
		   rCurrentIndex.setText("");
		   return;
	   }	   
       RColumn[Index2][0]=new String(rCurrentIndex.getText());	   
	   RColumn[Index2][1]=new String(SColumn[i][0]);
	   RColumn[Index2][2]=new String(SColumn[i][1]);
	   RColumn[Index2][3]=new String(SColumn[i][2]);
	   rCurrentIndex.setText("");
	 
	   RequiredColumns.revalidate();
	   RequiredColumns.repaint();
	   Index2++;
 } 
 /* Viewing the already added Column Meta Data */
 public class viewClickListener implements ActionListener
 {
	 public void actionPerformed(ActionEvent ae)
	 {
		new ViewColumnMetaData(); 
	 }
 }

 
 //Frame for viewing column meta data
public class ViewColumnMetaData
{   
	private JFrame viewFrame;
	private JTable jt=new JTable(); 
	private JScrollPane sp=new JScrollPane(jt);
	private JPanel bPanel=new JPanel();
	private JButton removeColumn=new JButton("Remove");
	DefaultTableModel model=new DefaultTableModel();
	public ViewColumnMetaData()
	{
		initialize();
	}
	private void initialize()
	{   mFrame.setEnabled(false);
		viewFrame = new JFrame();
		viewFrame.setSize(600,600);
		viewFrame.setTitle("Column Meta Data");
		viewFrame.setLocationRelativeTo(null); 
		viewFrame.setResizable(false);
		viewFrame.setVisible(true);
		viewFrame.getContentPane().setLayout(null);    
		viewFrame.addComponentListener(new ComponentAdapter() {
	        
	         public void componentMoved(ComponentEvent e) {
	            viewFrame.setLocation(300,20);
	         }
	      });
		ViewCMD();
		
		sp.setSize(new Dimension(595,500));
		removeColumn.setBounds(0,550,100,30);
		bPanel.setBounds(0,510,600,90);
		bPanel.setSize(new Dimension(600,50));
		viewFrame.getContentPane().add(sp);   
		viewFrame.getContentPane().add(bPanel);
		
		bPanel.add(removeColumn);
				
		//Removing ColumnMetaData
		removeColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=jt.getSelectedRow();
				if(i>=0)
				{
					RemoveColumn(i);
				}
				
			}
		});
		viewFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {   mFrame.setEnabled(true);
                e.getWindow().dispose();
            }
        });
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void ViewCMD()
	{  	Object[] columns={"Index","Column Name","Data Type","Format","Function State","Transposable"};
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		model.setRowCount(0);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);	
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Viewing the Column Meta Data
				Object[] row=new Object[6];
				for(int i=0;i<Index1;i++)
				{
					row[0]=i;
					row[1]=SColumn[i][0];
					row[2]=SColumn[i][1];
					row[3]=SColumn[i][2];
					row[4]=SColumn[i][3];
					row[5]=SColumn[i][4];
					model.addRow(row);
				}
	}
	
	public void RemoveColumn(int index)
	{
		
		for(int j=index;j<Index1;j++)
		{
			SColumn[j][0]=SColumn[j+1][0];
			SColumn[j][1]=SColumn[j+1][1];
			SColumn[j][2]=SColumn[j+1][2];
			SColumn[j][3]=SColumn[j+1][3];
			SColumn[j][4]=SColumn[j+1][4];
		}
		int flag=0,k;
		for(k=0;k<Index2;k++)
		{
			if(index==Integer.parseInt(RColumn[k][0]))
			{
				flag=1; break;
			}
		}
		if(flag==1)
		{
			for(int l=k;l<Index2;l++)
			{
				RColumn[l][0]=RColumn[l+1][0];
				RColumn[l][1]=RColumn[l+1][1];
				RColumn[l][2]=RColumn[l+1][2];
				RColumn[l][3]=RColumn[l+1][3];
			}
			Index2--;
		}
		Index1--;
		ViewCMD();
		
	}
	
}
/*For Viewing Required Columns*/
public class RviewActionListener implements ActionListener{
	public void actionPerformed(ActionEvent ae)
	   {
		new ViewRequiredColumnData();
	   }
	}

public class ViewRequiredColumnData
{   private JFrame viewFrame;
	private JTable jt=new JTable(); 
	private JScrollPane sp=new JScrollPane(jt);
	private JPanel bPanel=new JPanel();
	private JButton removeColumn=new JButton("Remove");
	DefaultTableModel model=new DefaultTableModel();
	public ViewRequiredColumnData()
	{
		initialize();
	}
	private void initialize()
	{   mFrame.setEnabled(false);
		viewFrame = new JFrame();
		viewFrame.setSize(600,600);
		viewFrame.setTitle("Column Meta Data");
		viewFrame.setLocationRelativeTo(null); 
		viewFrame.setResizable(false);
		viewFrame.setVisible(true);
		viewFrame.getContentPane().setLayout(null);    
		viewFrame.addComponentListener(new ComponentAdapter() {
	        
	         public void componentMoved(ComponentEvent e) {
	            viewFrame.setLocation(300,20);
	         }
	      });
		ViewCMD();
		
		sp.setSize(new Dimension(595,500));
		removeColumn.setBounds(0,550,100,30);
		bPanel.setBounds(0,510,600,90);
		bPanel.setSize(new Dimension(600,50));
		viewFrame.getContentPane().add(sp);   
		viewFrame.getContentPane().add(bPanel);
				
		bPanel.add(removeColumn);
			
		//Removing ReqColumnMetaData
		removeColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=jt.getSelectedRow();
				if(i>=0)
				{
					RemoveColumn(i);
				}
				
			}
		});
		viewFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {   mFrame.setEnabled(true);
                e.getWindow().dispose();
            }
        });
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void RemoveColumn(int index)
	{    
		for(int j=index;j<Index2;j++)
		{
			RColumn[j][0]=RColumn[j+1][0];
			RColumn[j][1]=RColumn[j+1][1];
			RColumn[j][2]=RColumn[j+1][2];
			RColumn[j][3]=RColumn[j+1][3];
		}
		Index2--;
		ViewCMD();
	}
	public void ViewCMD()
	{
		Object[] columns={"Index","Current Index","Column Name","Data Type","Format"};
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		model.setRowCount(0);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);	
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Viewing the Req Column Meta Data
				Object[] row=new Object[6];
				for(int i=0;i<Index2;i++)
				{
					row[0]=i;
					row[1]=RColumn[i][0];
					row[2]=RColumn[i][1];
					row[3]=RColumn[i][2];
					row[4]=RColumn[i][3];
					model.addRow(row);
				}
	}
}
//Adding Data Quality Data Columns
public class DAddClickListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		   DColumn[Index3][0]=new String(Minimum.getText());	   
		   DColumn[Index3][1]=new String(Maximum.getText());
		   DColumn[Index3][2]=new String(ParameterName.getText());
		   Minimum.setText("");	    
		   Maximum.setText("");
		   ParameterName.setText("");
		   ColumnMetaData.revalidate();
		   ColumnMetaData.repaint();
		   Index3++;
	}
	
}
//For viewing data quality data columns
public class DViewClickListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new DataQualityDataColumns();
	}
	
}
public class DataQualityDataColumns
{   private JFrame viewFrame;
	private JTable jt=new JTable(); 
	private JScrollPane sp=new JScrollPane(jt);
	private JPanel bPanel=new JPanel();
	private JButton removeColumn=new JButton("Remove");
	DefaultTableModel model=new DefaultTableModel();
	public DataQualityDataColumns()
	{
		initialize();
	}
	private void initialize()
	{   mFrame.setEnabled(false);
		viewFrame = new JFrame();
		viewFrame.setSize(600,600);
		viewFrame.setTitle("Data Quality Data");
		viewFrame.setLocationRelativeTo(null); 
		viewFrame.setResizable(false);
		viewFrame.setVisible(true);
		viewFrame.getContentPane().setLayout(null);    
		viewFrame.addComponentListener(new ComponentAdapter() {
	        
	         public void componentMoved(ComponentEvent e) {
	            viewFrame.setLocation(300,20);
	         }
	      });
		ViewCMD();
		
		sp.setSize(new Dimension(595,500));
		removeColumn.setBounds(0,550,100,30);
		bPanel.setBounds(0,510,600,90);
		bPanel.setSize(new Dimension(600,50));
		viewFrame.getContentPane().add(sp);   
		viewFrame.getContentPane().add(bPanel);
				
		bPanel.add(removeColumn);
			
		//Removing ColumnMetaData
		removeColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=jt.getSelectedRow();
				if(i>=0)
				{
					RemoveColumn(i);
				}
				
			}
		});
		viewFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {   mFrame.setEnabled(true);
                e.getWindow().dispose();
            }
        });
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void RemoveColumn(int index)
	{    
		for(int j=index;j<Index3;j++)
		{
			DColumn[j][0]=DColumn[j+1][0];
			DColumn[j][1]=DColumn[j+1][1];
			DColumn[j][2]=DColumn[j+1][2];
			
		}
		Index3--;
		ViewCMD();
	}
	public void ViewCMD()
	{
		Object[] columns={"Index","Minimum","Maximum","Parameter Name"};
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		model.setRowCount(0);
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);	
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Viewing the Column Meta Data
				Object[] row=new Object[4];
				for(int i=0;i<Index3;i++)
				{
					row[0]=i;
					row[1]=DColumn[i][0];
					row[2]=DColumn[i][1];
					row[3]=DColumn[i][2];
					model.addRow(row);
				}
	}
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.mFrame.setVisible(true);
					window.mFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createGUI();
	}
}
