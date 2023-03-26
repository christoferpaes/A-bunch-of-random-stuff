# CSC230 Fa21 Midterm
# Name: Christofer Paes  
# //Write the assembly for the following loop
# //Use either indexed or pointer array access
#   const int SIZE = 16;
#   int A[SIZE];
#   for (int i=SIZE-1; i >= 0; i--) {
#       A[i+1] = A[i] * 2; 
#   }
.data   # DO NOT CHANGE THIS TEST DATA
 .eqv    SYS_PRINT_WORD   1  #word, byte, character
    .eqv    SYS_PRINT_FLOAT  2  #float  
    .eqv    SYS_PRINT_DOUBLE 3  #double
    .eqv    SYS_PRINT_TEXT   4  #text (zero terminated)
    .eqv    SYS_EXIT        10  #terminate
    
A:      .word       0,  1,  2,  3,  4,  5,  6,  7,
        .word       8,  9, 10, 11, 12, 13, 14 
Asize:  .word      15, 16          
SIZE:   .word      16
iSum: 	.word 	0 
    blank:  .asciiz     " "
    
.text
.globl main
main:	

la $t0, A ## this is the starting address 
lw $t1,Asize
li $t2,0 
li $t4, 2
    #TODO: Write the loop code: A[i+1] = A[i] * 2


loop:
	lw $t3, ($t0) ## this sets the index to $t3
	mult $t3, $t4
	mflo $t5
	sw $t5, iSum ## store the word in memory
	lw $a0, iSum ## load the word from memory 
	li $v0, SYS_PRINT_WORD  # print 
	syscall
	
	la $a0, blank
	li $v0, SYS_PRINT_TEXT ## blank 
	syscall
	
	addu $t0,$t0, 4  ## offset by four because it is a word
	sub $t1, $t1, 1 
	bnez $t1, loop
	

exit: 
    li      $v0, 10
    syscall 




