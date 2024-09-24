	.text
	.file	"test2.ll"
	.globl	main                            # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	$6, 4(%rsp)
	movl	$3, (%rsp)
	xorl	%eax, %eax
	testb	%al, %al
	jne	.LBB0_2
# %bb.1:                                # %L2
	movl	$.L.str6, %edi
	jmp	.LBB0_7
.LBB0_2:                                # %L3
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jne	.LBB0_4
# %bb.3:                                # %L5
	movl	$.L.str11, %edi
	jmp	.LBB0_7
.LBB0_4:                                # %L6
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jge	.LBB0_6
# %bb.5:                                # %L8
	movl	$.L.str16, %edi
	jmp	.LBB0_7
.LBB0_6:                                # %L9
	movl	$.L.str18, %edi
.LBB0_7:                                # %L1
	xorl	%eax, %eax
	callq	printf
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jle	.LBB0_9
# %bb.8:                                # %L12
	movl	$.L.str23, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_9:                                # %L13
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jle	.LBB0_13
# %bb.10:                               # %L15
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jle	.LBB0_13
# %bb.11:                               # %L18
	movl	4(%rsp), %eax
	cmpl	(%rsp), %eax
	jle	.LBB0_13
# %bb.12:                               # %L21
	movl	$.L.str34, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_13:                               # %L16
	xorl	%eax, %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str6,@object                 # @.str6
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str6:
	.asciz	"a>b\n"
	.size	.L.str6, 5

	.type	.L.str11,@object                # @.str11
.L.str11:
	.asciz	"a==b\n"
	.size	.L.str11, 6

	.type	.L.str16,@object                # @.str16
.L.str16:
	.asciz	"a<b\n"
	.size	.L.str16, 5

	.type	.L.str18,@object                # @.str18
.L.str18:
	.asciz	"bad\n"
	.size	.L.str18, 5

	.type	.L.str23,@object                # @.str23
.L.str23:
	.asciz	"equal\n"
	.size	.L.str23, 7

	.type	.L.str34,@object                # @.str34
.L.str34:
	.asciz	"hehe\n"
	.size	.L.str34, 6

	.section	".note.GNU-stack","",@progbits
