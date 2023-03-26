 #Name: Christofer Paes
 # Teacher: Kurt Marley , School = GCC.
 # File: mlGraphicSissor
#  Author:Christofer Paes 
#    Date: 11/09/2021
# Purpose: Use AND of bits to make decisions; see mlGraphicsSissor.pptx
#--------------------------------------------------------------
# Write a MIPS determine if parts of lines are in a display window
# RESULT: (***NOTE: BINARY [codes] will be 32-bits, leading 0's***)
# (1,1)-(1,5) --> [0010]&[0010] = [0010]  no 
# (3,2)-(5,4) --> [0000]&[0000] = [0000]  yes
# (0,0)-(7,7) --> [0110]&[1001] = [0000]  yes
# (1,3)-(4,3) --> [0010]&[0000] = [0000]  yes
.data
    .eqv    SYS_PRINT_WORD   1  #word, byte, character
    .eqv    SYS_PRINT_FLOAT  2  #float  
    .eqv    SYS_PRINT_DOUBLE 3  #double
    .eqv    SYS_PRINT_TEXT   4  #text (zero terminated)
    .eqv    SYS_INPUT_WORD   5  #input word
    .eqv    SYS_INPUT_FLOAT  6      #input float
    .eqv    SYS_PRINT_BIN   35  #print binary
    .eqv    SYS_EXIT        10  #terminate

# declare variables
    .eqv    SIZE    16
    .eqv    UP      5       # display window sides
    .eqv    DOWN    1       # (1,2) to (6,5)
    .eqv    LEFT    2
    .eqv    RIGHT   6
    
    pts:    .byte   1,1, 1,5,   
            .byte   3,2, 5,4,   
            .byte   0,0, 7,7,   
            .byte   1,3, 4,3
    end_pts:
    openParen:  .asciiz "("
    comma:      .asciiz ","
    parenCntr:  .asciiz ")-("
    arrow:      .asciiz ") --> ["
    braceCntr:  .asciiz "]&["
    equal:      .asciiz "] = ["
    yes:        .asciiz "]  yes"
    no:         .asciiz "]  no "
    endl:       .asciiz     "\n"
    divider:    .asciiz    " --------------------------------------- ]"
    s:          .asciiz   " "
    s3:         .asciiz " this is  s 3 "    
    
.text
.globl main
main:

# ----------------------------------------------------------------
# Main loop
# ----------------------------------------------------------------
    la    $s0, pts     # s0 = pts[]
    la    $s7, end_pts # s7 = end_pts
    li   $t2, SIZE	
    li $t1, DOWN
    li $t3, LEFT
    li $t4, RIGHT
    li $t5, 9
    
    
    
loop1:
    # print numbers "(x0,y1)-(x2,y3) --> "
    la    $a0, openParen
    li    $v0, SYS_PRINT_TEXT
    syscall
    lbu   $a0, 0($s0)     # x0
    move  $s1, $a0  # x0
    li    $v0, SYS_PRINT_WORD
    syscall
    la    $a0, comma
    li    $v0, SYS_PRINT_TEXT 
    syscall
    lbu   $a0, 1($s0)     # y0
    move $s1, $a0
    li    $v0, SYS_PRINT_WORD
    syscall
   
    la  $a0, comma
    li  $v0, SYS_PRINT_TEXT
    syscall
    lbu $a0, 2($s0) 	#x2
    move $s2, $a0
    li $v0, SYS_PRINT_WORD
    syscall   
    
    la  $a0, comma
    li  $v0, SYS_PRINT_TEXT
    syscall
    lbu  $a0, 3($s0)
   move $s2, $a0
    li   $v0, SYS_PRINT_WORD
    syscall
   
    
    la  $a0, arrow
    li $v0, SYS_PRINT_TEXT
    syscall
  
  
  la $a0 , divider
  li $v0, 4
  syscall
  la $a0, endl
  li $v0, 4
  syscall
  la $a0, endl
  li $v0, 4
  syscall
  
and $s3, $s2, $s1
beqz $s3, noo
li $s7, 1
beq  $s3, $s7, yess
      
    
   
 yess:
 la $a0, ($s1)
 li $v0, 1
 syscall
  la $a0, endl
 li $v0, 4
 syscall
 li $v0, 35
 syscall
 la $a0, ($s2)
 li $v0, 1
 syscall
 la $a0, s
 li $v0, 4
 syscall
  la $a0, endl
 li $v0, 4
 syscall
 li $v0, 35
 syscall
 la $a0, yes
 li $v0, 4
 syscall
  la $a0, endl
 li $v0, 4
 syscall
 la $a0, ($s3)
 li $v0, 1
 syscall
  la $a0, s3
  li $v0, 4
  syscall
  la $a0, ($s3)
  li $v0, 35
  syscall
 
  
 jal locCode
 
 
 noo:
  la $a0, ($s1)
 li $v0, 1
 syscall
 la $a0, endl
 li $v0, 4
 syscall
 li $v0, 35
 syscall
 la $a0, ($s2)
 li $v0, 1
 syscall
 la $a0, s
 li $v0, 4
 syscall
  la $a0, endl
 li $v0, 4
 syscall
 li $v0, 35
 syscall
 la $a0, no
 li $v0, 4
 syscall
  la $a0, endl
 li $v0, 4
 syscall
 la $a0 , ($s3)
 li $v0, 1
 syscall
 la $a0, s3
  li $v0, 4
  syscall
 la $a0, ($s3)
 li $v0, 35
 syscall
 jal locCode

 	


    # call locCode() to get 1st point code for (x0,y1) in s1
    


   
   
    
    
    


    # print divider between codes

   
    # call locCode() to get 2nd point code for (x2,y3) in s2

    # print the 2nd s2 code

    # print divider

    # AND s1 & s2 codes to s3 and print it

    # print yes if s3 is zero, else print no
 
  
prt:    

    # print endl
    la    $a0, endl
    li    $v0, SYS_PRINT_TEXT
    syscall
    
    # end of main loop

    
#---- terminate ---
exit:
    li    $v0, SYS_EXIT
    syscall
    
# ----------------------------------------------------------------
# locCode() -- create 4-bit code
#   input:  $a0 = x
#           $a1 = y
#   output: $v0 = code [UP DOWN LEFT RIGHT]
# ----------------------------------------------------------------
locCode:
	    # print the 1st s1 code
li $t9, 4
add $t1, $t1, $t1 #increment the counter 
add $s0, $s0, 4
blt $t1, $t2, loop1 # branch if less than 16
beq $t1,$t9, exit 
        
#.end main