using System;

namespace Lesson13C
{
 
   public partial class Form1 : Form
    {
        int firstNumber;
        int secondNumber;

        public Form1()
        {
            InitializeComponent();
        }
        //tryParse() method is used to check whether valid input is entered by user or not


        public bool tryParse()
        {
            if (!(int.TryParse(txtFirstNumber.Text, out firstNumber)) || !(int.TryParse(txtSecondNumber.Text, out secondNumber)))
            {
                // if conversion fails display result using MessageBox.Show();
                MessageBox.Show("Please enter a valid number.");
                return false;
            }
            //if conversion is valid return true for input
            return true;
        }
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (tryParse())
            {


                lblResult.Text = String.Format($"Addition of {firstNumber} and {secondNumber} is :{firstNumber + secondNumber}");
            }
        }
        //subtraction of two numbers
        private void btnSubtract_Click(object sender, EventArgs e)
        {

            if (tryParse())
            {
                //subtraction of firstNumber from secondNumber

                lblResult.Text = String.Format($"Subtraction of {firstNumber} and {secondNumber} is :{firstNumber - secondNumber}");
            }
        }
        private void btnMultiply_Click(object sender, EventArgs e)
        {
            if (tryParse())
            {

                lblResult.Text = String.Format($"Multiplication of {firstNumber} and {secondNumber} is :{firstNumber * secondNumber}");
            }
        }

        private void btnDivide_Click(object sender, EventArgs e)
        {

            if (tryParse())
            {


                lblResult.Text = String.Format($"Division of {firstNumber} and {secondNumber} is :{firstNumber / secondNumber}");
            }
        }
        private void Form1_Load(object sender, EventArgs e)
        {
        }
    }
}
Form1.Designer.cs CODE;
{
    {
    partial class Form1
{
    /// <summary>
    /// Required designer variable.
    /// </summary>
    private System.ComponentModel.IContainer components = null;
    /// <summary>
    /// Clean up any resources being used.
    /// </summary>
    /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
    protected override void Dispose(bool disposing)
    {
        if (disposing && (components != null))
        {
            components.Dispose();
        }
        base.Dispose(disposing);
    }
    #region Windows Form Designer generated code
    /// <summary>
    /// Required method for Designer support - do not modify
    /// the contents of this method with the code editor.
    /// </summary>
    private void InitializeComponent()
    {
        this.groupBox1 = new System.Windows.Forms.GroupBox();
        this.txtFirstNumber = new System.Windows.Forms.TextBox();
        this.txtSecondNumber = new System.Windows.Forms.TextBox();
        this.label2 = new System.Windows.Forms.Label();
        this.label1 = new System.Windows.Forms.Label();
        this.lblResult = new System.Windows.Forms.Label();
        this.btnAdd = new System.Windows.Forms.Button();
        this.btnSubtract = new System.Windows.Forms.Button();
        this.btnMultiply = new System.Windows.Forms.Button();
        this.btnDivide = new System.Windows.Forms.Button();
        this.groupBox2 = new System.Windows.Forms.GroupBox();
        this.groupBox1.SuspendLayout();
        this.groupBox2.SuspendLayout();
        this.SuspendLayout();
        this.groupBox1.Controls.Add(this.txtFirstNumber);
        this.groupBox1.Controls.Add(this.txtSecondNumber);
        this.groupBox1.Controls.Add(this.label2);
        this.groupBox1.Controls.Add(this.label1);
        this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.groupBox1.Location = new System.Drawing.Point(116, 42);
        this.groupBox1.Margin = new System.Windows.Forms.Padding(4);
        this.groupBox1.Name = "groupBox1";
        this.groupBox1.Padding = new System.Windows.Forms.Padding(4);
        this.groupBox1.Size = new System.Drawing.Size(489, 188);
        this.groupBox1.TabIndex = 0;
        this.groupBox1.TabStop = false;
        this.txtFirstNumber.Location = new System.Drawing.Point(249, 39);
        this.txtFirstNumber.Margin = new System.Windows.Forms.Padding(4);
        this.txtFirstNumber.Name = "txtFirstNumber";
        this.txtFirstNumber.Size = new System.Drawing.Size(173, 28);
        this.txtFirstNumber.TabIndex = 8;
        this.txtSecondNumber.Location = new System.Drawing.Point(249, 111);
        this.txtSecondNumber.Margin = new System.Windows.Forms.Padding(4);
        this.txtSecondNumber.Name = "txtSecondNumber";
        this.txtSecondNumber.Size = new System.Drawing.Size(173, 28);
        this.txtSecondNumber.TabIndex = 7;
        this.label2.AutoSize = true;
        this.label2.Location = new System.Drawing.Point(19, 118);
        this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.label2.Name = "label2";
        this.label2.Size = new System.Drawing.Size(200, 24);
        this.label2.TabIndex = 1;
        this.label2.Text = "Enter Second Number";
        this.label1.AutoSize = true;
        this.label1.Location = new System.Drawing.Point(19, 47);
        this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.label1.Name = "label1";
        this.label1.Size = new System.Drawing.Size(169, 24);
        this.label1.TabIndex = 0;
        this.label1.Text = "Enter First Number";
        this.lblResult.AutoSize = true;
        this.lblResult.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
        this.lblResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.lblResult.Location = new System.Drawing.Point(245, 377);
        this.lblResult.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.lblResult.Name = "lblResult";
        this.lblResult.Size = new System.Drawing.Size(0, 25);
        this.lblResult.TabIndex = 2;
        this.btnAdd.Location = new System.Drawing.Point(23, 28);
        this.btnAdd.Margin = new System.Windows.Forms.Padding(4);
        this.btnAdd.Name = "btnAdd";
        this.btnAdd.Size = new System.Drawing.Size(100, 43);
        this.btnAdd.TabIndex = 3;
        this.btnAdd.Text = "Add";
        this.btnAdd.UseVisualStyleBackColor = true;
        this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
        this.btnSubtract.Location = new System.Drawing.Point(135, 28);
        this.btnSubtract.Margin = new System.Windows.Forms.Padding(4);
        this.btnSubtract.Name = "btnSubtract";
        this.btnSubtract.Size = new System.Drawing.Size(113, 43);
        this.btnSubtract.TabIndex = 4;
        this.btnSubtract.Text = "Subtract";
        this.btnSubtract.UseVisualStyleBackColor = true;
        this.btnSubtract.Click += new System.EventHandler(this.btnSubtract_Click);
        this.btnMultiply.Location = new System.Drawing.Point(269, 28);
        this.btnMultiply.Margin = new System.Windows.Forms.Padding(4);
        this.btnMultiply.Name = "btnMultiply";
        this.btnMultiply.Size = new System.Drawing.Size(104, 43);
        this.btnMultiply.TabIndex = 5;
        this.btnMultiply.Text = "Multiply";
        this.btnMultiply.UseVisualStyleBackColor = true;
        this.btnMultiply.Click += new System.EventHandler(this.btnMultiply_Click);
        this.btnDivide.Location = new System.Drawing.Point(381, 28);
        this.btnDivide.Margin = new System.Windows.Forms.Padding(4);
        this.btnDivide.Name = "btnDivide";
        this.btnDivide.Size = new System.Drawing.Size(100, 43);
        this.btnDivide.TabIndex = 6;
        this.btnDivide.Text = "Divide";
        this.btnDivide.UseVisualStyleBackColor = true;
        this.btnDivide.Click += new System.EventHandler(this.btnDivide_Click);

        this.groupBox2.Controls.Add(this.btnDivide);
        this.groupBox2.Controls.Add(this.btnMultiply);
        this.groupBox2.Controls.Add(this.btnAdd);
        this.groupBox2.Controls.Add(this.btnSubtract);
        this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.groupBox2.Location = new System.Drawing.Point(116, 254);
        this.groupBox2.Margin = new System.Windows.Forms.Padding(4);
        this.groupBox2.Name = "groupBox2";
        this.groupBox2.Padding = new System.Windows.Forms.Padding(4);
        this.groupBox2.Size = new System.Drawing.Size(489, 87);
        this.groupBox2.TabIndex = 9;
        this.groupBox2.TabStop = false;
        this.groupBox2.Text = "Operation";

        this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
        this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        this.ClientSize = new System.Drawing.Size(703, 431);
        this.Controls.Add(this.groupBox2);
        this.Controls.Add(this.groupBox1);
        this.Controls.Add(this.lblResult);
        this.Margin = new System.Windows.Forms.Padding(4);
        this.Name = "Form1";
        this.Text = " Calculation";
        this.groupBox1.ResumeLayout(false);
        this.groupBox1.PerformLayout();
        this.groupBox2.ResumeLayout(false);
        this.ResumeLayout(false);
        this.PerformLayout();
    }
    #endregion
    private System.Windows.Forms.GroupBox groupBox1;
    private System.Windows.Forms.TextBox txtFirstNumber;
    private System.Windows.Forms.TextBox txtSecondNumber;
    private System.Windows.Forms.Label lblResult;
    private System.Windows.Forms.Label label2;
    private System.Windows.Forms.Label label1;
    private System.Windows.Forms.Button btnAdd;
    private System.Windows.Forms.Button btnSubtract;
    private System.Windows.Forms.Button btnMultiply;
    private System.Windows.Forms.Button btnDivide;
    private System.Windows.Forms.GroupBox groupBox2;
}
}
 Lesson13C



    public partial class Form1 : Form
{
    // two integer variables to hold the numbers entered by user
    int firstNumber;
    int secondNumber;
    //class constructor
    public Form1()
    {
        InitializeComponent();
    }
    //tryParse() method is used to check whether valid input is entered by user or not


    public bool tryParse()
    {
        if (!(int.TryParse(txtFirstNumber.Text, out firstNumber)) || !(int.TryParse(txtSecondNumber.Text, out secondNumber)))
        {
            // if conversion fails display result using MessageBox.Show();
            MessageBox.Show("Please enter a valid number.");
            return false;
        }
        return true;
    }

    private void btnAdd_Click(object sender, EventArgs e)
    {
        if (tryParse())
        {
            //addition of firstNumber with secondNumber

            lblResult.Text = String.Format($"Addition of {firstNumber} and {secondNumber} is :{firstNumber + secondNumber}");
        }
    }
    //subtraction of two numbers
    private void btnSubtract_Click(object sender, EventArgs e)
    {
        if (tryParse())
        {

            lblResult.Text = String.Format($"Subtraction of {firstNumber} and {secondNumber} is :{firstNumber - secondNumber}");
        }
    }
    //Multiplication of two numbers
    private void btnMultiply_Click(object sender, EventArgs e)
    {

        if (tryParse())
        {

            lblResult.Text = String.Format($"Multiplication of {firstNumber} and {secondNumber} is :{firstNumber * secondNumber}");
        }
    }
    //Division of two numbers
    private void btnDivide_Click(object sender, EventArgs e)
    {
        if (tryParse())
        {

            lblResult.Text = String.Format($"Division of {firstNumber} and {secondNumber} is :{firstNumber / secondNumber}");
        }
    }
    private void Form1_Load(object sender, EventArgs e)
    {
    }
}
}
2. Form1.Designer.cs CODE:
{
    partial class Form1
{
    /// <summary>
    /// Required designer variable.
    /// </summary>
    private System.ComponentModel.IContainer components = null;
    /// <summary>
    /// Clean up any resources being used.
    /// </summary>
    /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
    protected override void Dispose(bool disposing)
    {
        if (disposing && (components != null))
        {
            components.Dispose();
        }
        base.Dispose(disposing);
    }
    #region Windows Form Designer generated code
    /// <summary>
    /// Required method for Designer support - do not modify
    /// the contents of this method with the code editor.
    /// </summary>
    private void InitializeComponent()
    {
        this.groupBox1 = new System.Windows.Forms.GroupBox();
        this.txtFirstNumber = new System.Windows.Forms.TextBox();
        this.txtSecondNumber = new System.Windows.Forms.TextBox();
        this.label2 = new System.Windows.Forms.Label();
        this.label1 = new System.Windows.Forms.Label();
        this.lblResult = new System.Windows.Forms.Label();
        this.btnAdd = new System.Windows.Forms.Button();
        this.btnSubtract = new System.Windows.Forms.Button();
        this.btnMultiply = new System.Windows.Forms.Button();
        this.btnDivide = new System.Windows.Forms.Button();
        this.groupBox2 = new System.Windows.Forms.GroupBox();
        this.groupBox1.SuspendLayout();
        this.groupBox2.SuspendLayout();
        this.SuspendLayout();

        this.groupBox1.Controls.Add(this.txtFirstNumber);
        this.groupBox1.Controls.Add(this.txtSecondNumber);
        this.groupBox1.Controls.Add(this.label2);
        this.groupBox1.Controls.Add(this.label1);
        this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.groupBox1.Location = new System.Drawing.Point(116, 42);
        this.groupBox1.Margin = new System.Windows.Forms.Padding(4);
        this.groupBox1.Name = "groupBox1";
        this.groupBox1.Padding = new System.Windows.Forms.Padding(4);
        this.groupBox1.Size = new System.Drawing.Size(489, 188);
        this.groupBox1.TabIndex = 0;
        this.groupBox1.TabStop = false;

        this.txtFirstNumber.Location = new System.Drawing.Point(249, 39);
        this.txtFirstNumber.Margin = new System.Windows.Forms.Padding(4);
        this.txtFirstNumber.Name = "txtFirstNumber";
        this.txtFirstNumber.Size = new System.Drawing.Size(173, 28);
        this.txtFirstNumber.TabIndex = 8;

        this.txtSecondNumber.Location = new System.Drawing.Point(249, 111);
        this.txtSecondNumber.Margin = new System.Windows.Forms.Padding(4);
        this.txtSecondNumber.Name = "txtSecondNumber";
        this.txtSecondNumber.Size = new System.Drawing.Size(173, 28);
        this.txtSecondNumber.TabIndex = 7;

        this.label2.AutoSize = true;
        this.label2.Location = new System.Drawing.Point(19, 118);
        this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.label2.Name = "label2";
        this.label2.Size = new System.Drawing.Size(200, 24);
        this.label2.TabIndex = 1;
        this.label2.Text = "Enter Second Number";

        this.label1.AutoSize = true;
        this.label1.Location = new System.Drawing.Point(19, 47);
        this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.label1.Name = "label1";
        this.label1.Size = new System.Drawing.Size(169, 24);
        this.label1.TabIndex = 0;
        this.label1.Text = "Enter First Number";

        this.lblResult.AutoSize = true;
        this.lblResult.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(128)))));
        this.lblResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.lblResult.Location = new System.Drawing.Point(245, 377);
        this.lblResult.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
        this.lblResult.Name = "lblResult";
        this.lblResult.Size = new System.Drawing.Size(0, 25);
        this.lblResult.TabIndex = 2;
        this.btnAdd.Location = new System.Drawing.Point(23, 28);
        this.btnAdd.Margin = new System.Windows.Forms.Padding(4);
        this.btnAdd.Name = "btnAdd";
        this.btnAdd.Size = new System.Drawing.Size(100, 43);
        this.btnAdd.TabIndex = 3;
        this.btnAdd.Text = "Add";
        this.btnAdd.UseVisualStyleBackColor = true;
        this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
        this.btnSubtract.Location = new System.Drawing.Point(135, 28);
        this.btnSubtract.Margin = new System.Windows.Forms.Padding(4);
        this.btnSubtract.Name = "btnSubtract";
        this.btnSubtract.Size = new System.Drawing.Size(113, 43);
        this.btnSubtract.TabIndex = 4;
        this.btnSubtract.Text = "Subtract";
        this.btnSubtract.UseVisualStyleBackColor = true;
        this.btnSubtract.Click += new System.EventHandler(this.btnSubtract_Click;
        this.btnMultiply.Location = new System.Drawing.Point(269, 28);
        this.btnMultiply.Margin = new System.Windows.Forms.Padding(4);
        this.btnMultiply.Name = "btnMultiply";
        this.btnMultiply.Size = new System.Drawing.Size(104, 43);
        this.btnMultiply.TabIndex = 5;
        this.btnMultiply.Text = "Multiply";
        this.btnMultiply.UseVisualStyleBackColor = true;
        this.btnMultiply.Click += new System.EventHandler(this.btnMultiply_Click;
        this.btnDivide.Location = new System.Drawing.Point(381, 28);
        this.btnDivide.Margin = new System.Windows.Forms.Padding(4);
        this.btnDivide.Name = "btnDivide";
        this.btnDivide.Size = new System.Drawing.Size(100, 43);
        this.btnDivide.TabIndex = 6;
        this.btnDivide.Text = "Divide";
        this.btnDivide.UseVisualStyleBackColor = true;
        this.btnDivide.Click += new System.EventHandler(this.btnDivide_Click);

        this.groupBox2.Controls.Add(this.btnDivide);
        this.groupBox2.Controls.Add(this.btnMultiply);
        this.groupBox2.Controls.Add(this.btnAdd);
        this.groupBox2.Controls.Add(this.btnSubtract);
        this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
        this.groupBox2.Location = new System.Drawing.Point(116, 254);
        this.groupBox2.Margin = new System.Windows.Forms.Padding(4);
        this.groupBox2.Name = "groupBox2";
        this.groupBox2.Padding = new System.Windows.Forms.Padding(4);
        this.groupBox2.Size = new System.Drawing.Size(489, 87);
        this.groupBox2.TabIndex = 9;
        this.groupBox2.TabStop = false;
        this.groupBox2.Text = "Operation";
        //
        // Form1
        //
        this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
        this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        this.ClientSize = new System.Drawing.Size(703, 431);
        this.Controls.Add(this.groupBox2);
        this.Controls.Add(this.groupBox1);
        this.Controls.Add(this.lblResult);
        this.Margin = new System.Windows.Forms.Padding(4);
        this.Name = "Form1";
        this.Text = " Calculation";
        this.groupBox1.ResumeLayout(false);
        this.groupBox1.PerformLayout();
        this.groupBox2.ResumeLayout(false);
        this.ResumeLayout(false);
        this.PerformLayout();
    }
    #endregion
    private System.Windows.Forms.GroupBox groupBox1;
    private System.Windows.Forms.TextBox txtFirstNumber;
    private System.Windows.Forms.TextBox txtSecondNumber;
    private System.Windows.Forms.Label lblResult;
    private System.Windows.Forms.Label label2;
    private System.Windows.Forms.Label label1;
    private System.Windows.Forms.Button btnAdd;
    private System.Windows.Forms.Button btnSubtract;
    private System.Windows.Forms.Button btnMultiply;
    private System.Windows.Forms.Button btnDivide;
    private System.Windows.Forms.GroupBox groupBox2;
}
}
