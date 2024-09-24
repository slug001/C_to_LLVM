	.text
	.file	"test1.ll"
	.globl	main                            # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	$80, 12(%rsp)
	movl	$90, 8(%rsp)
	movb	$1, %al
	testb	%al, %al
	jne	.LBB0_2
# %bb.1:                                # %L2
	movl	$.L.str8, %edi
	jmp	.LBB0_3
.LBB0_2:                                # %L3
	movl	$.L.str10, %edi
.LBB0_3:                                # %L1
	xorl	%eax, %eax
	callq	printf
	movl	12(%rsp), %esi
	addl	8(%rsp), %esi
	movl	%esi, 20(%rsp)
	movl	$.L.str16, %edi
	xorl	%eax, %eax
	callq	printf
	movl	12(%rsp), %eax
	leal	1(%rax), %ecx
	movl	8(%rsp), %edx
	leal	-1(%rdx), %esi
	imull	%ecx, %esi
	leal	3(%rsi), %ecx
	testl	%esi, %esi
	cmovnsl	%esi, %ecx
	sarl	$2, %ecx
	leal	(%rcx,%rcx,4), %ecx
	subl	%edx, %ecx
	leal	1(%rcx,%rax,4), %esi
	movl	%esi, 16(%rsp)
	movl	$.L.str32, %edi
	xorl	%eax, %eax
	callq	printf
	cmpl	$69420, 16(%rsp)                # imm = 0x10F2C
	jg	.LBB0_5
# %bb.4:                                # %L6
	movl	$.L.str36, %edi
	jmp	.LBB0_6
.LBB0_5:                                # %L7
	movl	$.L.str38, %edi
.LBB0_6:                                # %L5
	xorl	%eax, %eax
	callq	printf
	xorl	%eax, %eax
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str8,@object                 # @.str8
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str8:
	.asciz	"a is greater than b\n"
	.size	.L.str8, 21

	.type	.L.str10,@object                # @.str10
.L.str10:
	.asciz	"a is grater or equal to b\n"
	.size	.L.str10, 27

	.type	.L.str16,@object                # @.str16
.L.str16:
	.asciz	"a + b = %d\n"
	.size	.L.str16, 12

	.type	.L.str32,@object                # @.str32
.L.str32:
	.asciz	"res = %d\n"
	.size	.L.str32, 10

	.type	.L.str36,@object                # @.str36
.L.str36:
	.asciz	"res is less than or equal to 69420\n"
	.size	.L.str36, 36

	.type	.L.str38,@object                # @.str38
.L.str38:
	.asciz	"res is greater than 69420\n"
	.size	.L.str38, 27

	.section	".note.GNU-stack","",@progbits
