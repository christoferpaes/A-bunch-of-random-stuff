#  Final Exam with subroutine, to sum some numbers
#  Author: Christofer Patrick Paes , 14-Dec-2021
# -------------------------------------------------
#  Data Declarations
#========================================================
# FINAL INCLASS
#========================================================
#  Program to sum numbers in an 
#  array of 8-bit integers (.byte)
#  and an array of 32-bit integers (.word) 
#  (You may use indexed or pointer access for the arrays)
#  -------------------------- C++ code ------------------
#  #include <iostream>
#  #include <string>
#  using namespace std;
#  void main()
#  {
#     const int SIZE = 8;
#     byte[] bytes = { 6, 5, -1, 9, 2, 3, -8, 2 };
#     int[]  words = { 6, 5,  1, 9, 2, 3,  8, 2 };
#     int sum = doSum(bytes, words, SIZE);
#     cout << sum << endl;
#  }
#  int doSum(byte& b, int& w, int n)
#  {
#     int sum = 0;
#     for(int x = 0; x < n-1; x+=2)
#     {
#       sum += w[x+1];
#       if ( b[x] < 0 )
#           sum = sum - b[x];
#       else
#           sum = sum + b[x];
#     }
#     return sum;
#  }

# -------------------------------------------------------
#  Data Declarations
.data
    .eqv    SYS_PRINT_WORD   1  #word, byte, character
    .eqv    SYS_PRINT_TEXT   4  #text (zero terminated)
    .eqv    SYS_EXIT        10  #terminate

            .eqv        SIZE        8
bytes:      .byte       6, 5, -1, -9, 2, 3, -8, 2
dummyFill:  .word	0,0,0,0,0,0
words:      .word       6, 5,  1, 9, 2, 3,  8, 2 
endl:       .asciiz     "\n"

# -------------------------------------------------
#  text/code section
.text
.globl  main 
main:
# ------
    #TODO: call doSum(bytes, words, SIZE) #sum returned in v0
    la $a0, bytes
    la $a1, words
    li $a2, SIZE 
    jal  doSum
    move $a0, $zero
    la $a0, ($s0)
    li $v0, 1
    syscall											
    #TODO: Print the v0 sum results
    la      $a0, endl
    li      $v0, SYS_PRINT_TEXT
    syscall
# ------
#  Done, terminate program. 
    li      $v0, SYS_EXIT   # call code for terminate
    syscall 
#.end main
#--------------------------------------------------------------
# Subroutine: doSum()
# Inputs:     $a0 - address of bytes[0] array of .byte 
#             $a1 - address of words[0] array of .word 
#             $a2 - SIZE of arrays
# Outputs:    $v0 - special sum
#--------------------------------------------------------------
doSum:
         move $v0, $zero      #sum = 0       
         move $s0, $zero
    #TODO: write the subroutine
    loop:
        move $t0 , $zero # zero the register
        move $t1, $zero # zero the register
        lb $t0, ($a0) #loading the byte from the byte array
        lw $t1, ($a1) # loading the word from the word array
        add $t2, $t0, $t1 # adding the word and byte together
        subi $a2, $a2, 1  # subtracting one from the SIZE		
        addu $a0, $a0, 1 # incrementing the address by 1
        addu $a1, $a1, 4 # incrementing the address by 4
        add $s0, $s0, $t2 # adding the values into s0 and continously adding the value into the register
        bnez $a2, loop # branch back to the top of the loop if size not zero
       
        jr      $ra # jump back to top or jump register to 31




    
