	.text
	.file	"test3.ll"
	.section	.rodata.cst8,"aM",@progbits,8
	.p2align	3                               # -- Begin function main
.LCPI0_0:
	.quad	0x4003333340000000              # double 2.4000000953674316
.LCPI0_1:
	.quad	0x3ff3333333333333              # double 1.2
.LCPI0_2:
	.quad	0x3fb9999800000000              # double 0.099999904632568359
.LCPI0_3:
	.quad	0x3ff8f5c2a0000000              # double 1.5600000619888306
.LCPI0_4:
	.quad	0x3ff1555540000000              # double 1.0833332538604736
.LCPI0_5:
	.quad	0x4033243180000000              # double 19.141380310058594
	.text
	.globl	main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	$1067030938, -8(%rbp)           # imm = 0x3F99999A
	movl	$0, -4(%rbp)
	movl	$3, -12(%rbp)
	.p2align	4, 0x90
.LBB0_1:                                # %L2
                                        # =>This Inner Loop Header: Depth=1
	movl	-4(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jge	.LBB0_3
# %bb.2:                                # %L3
                                        #   in Loop: Header=BB0_1 Depth=1
	incl	-4(%rbp)
	jmp	.LBB0_1
.LBB0_3:                                # %L4
	movl	-4(%rbp), %esi
	movl	$.L.str11, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$10, -12(%rbp)
	.p2align	4, 0x90
.LBB0_4:                                # %L6
                                        # =>This Inner Loop Header: Depth=1
	movl	-4(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jge	.LBB0_6
# %bb.5:                                # %L7
                                        #   in Loop: Header=BB0_4 Depth=1
	incl	-4(%rbp)
	jmp	.LBB0_4
.LBB0_6:                                # %L8
	movl	-4(%rbp), %esi
	movl	$.L.str19, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$1, -4(%rbp)
	jmp	.LBB0_7
	.p2align	4, 0x90
.LBB0_10:                               # %L16
                                        #   in Loop: Header=BB0_7 Depth=1
	incl	-4(%rbp)
.LBB0_7:                                # %L11
                                        # =>This Inner Loop Header: Depth=1
	cmpl	$4, -4(%rbp)
	jg	.LBB0_11
# %bb.8:                                # %L10
                                        #   in Loop: Header=BB0_7 Depth=1
	cmpl	$3, -4(%rbp)
	jl	.LBB0_10
# %bb.9:                                # %L15
                                        #   in Loop: Header=BB0_7 Depth=1
	movl	-4(%rbp), %esi
	movl	$.L.str28, %edi
	xorl	%eax, %eax
	callq	printf
	jmp	.LBB0_10
.LBB0_11:                               # %L13
	movl	$.L.str30, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	movl	$.L.str33, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	addl	%esi, %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str39, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	incl	%esi
	movl	%esi, -4(%rbp)
	movl	$.L.str44, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	incl	%esi
	movl	%esi, -4(%rbp)
	movl	$.L.str49, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$2, -4(%rbp)
	movl	$.L.str52, %edi
	movl	$2, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$0, -4(%rbp)
	movl	$.L.str58, %edi
	xorl	%esi, %esi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	decl	%esi
	movl	%esi, -4(%rbp)
	movl	$.L.str63, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$1, %esi
	subl	-4(%rbp), %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str68, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$2, -4(%rbp)
	movl	$.L.str71, %edi
	movl	$2, %esi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	imull	%esi, %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str77, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	addl	%esi, %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str82, %edi
	xorl	%eax, %eax
	callq	printf
	movl	-4(%rbp), %esi
	addl	%esi, %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str87, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$2, -4(%rbp)
	movl	$.L.str90, %edi
	movl	$2, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$1, -4(%rbp)
	movl	$.L.str96, %edi
	movl	$1, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$5, -4(%rbp)
	movl	$.L.str101, %edi
	movl	$5, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$6, %eax
	xorl	%edx, %edx
	idivl	-4(%rbp)
	movl	%eax, -4(%rbp)
	movl	$.L.str106, %edi
	movl	%eax, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$2, -4(%rbp)
	movl	$.L.str109, %edi
	movl	$2, %esi
	xorl	%eax, %eax
	callq	printf
	xorl	%esi, %esi
	subl	-4(%rbp), %esi
	movl	%esi, -4(%rbp)
	movl	$.L.str114, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$1075419546, -16(%rbp)          # imm = 0x4019999A
	movl	$1075419546, -8(%rbp)           # imm = 0x4019999A
	movsd	.LCPI0_0(%rip), %xmm0           # xmm0 = mem[0],zero
	movl	$.L.str120, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	addsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str128, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	addsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str136, %edi
	movb	$1, %al
	callq	printf
	movl	$1075419546, -8(%rbp)           # imm = 0x4019999A
	movl	$.L.str140, %edi
	movsd	.LCPI0_0(%rip), %xmm0           # xmm0 = mem[0],zero
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	subss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str147, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	subsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str155, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movsd	.LCPI0_1(%rip), %xmm1           # xmm1 = mem[0],zero
	subsd	%xmm0, %xmm1
	xorps	%xmm0, %xmm0
	cvtsd2ss	%xmm1, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str163, %edi
	movb	$1, %al
	callq	printf
	movl	$1036831936, -8(%rbp)           # imm = 0x3DCCCCC0
	movsd	.LCPI0_2(%rip), %xmm0           # xmm0 = mem[0],zero
	movl	$.L.str167, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	mulss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str174, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	mulsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str182, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	mulsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str190, %edi
	movb	$1, %al
	callq	printf
	movl	$1070050837, -8(%rbp)           # imm = 0x3FC7AE15
	movsd	.LCPI0_3(%rip), %xmm0           # xmm0 = mem[0],zero
	movl	$.L.str194, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	divss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str201, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	divsd	.LCPI0_1(%rip), %xmm0
	cvtsd2ss	%xmm0, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str209, %edi
	movb	$1, %al
	callq	printf
	movss	-8(%rbp), %xmm0                 # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movsd	.LCPI0_1(%rip), %xmm1           # xmm1 = mem[0],zero
	divsd	%xmm0, %xmm1
	xorps	%xmm0, %xmm0
	cvtsd2ss	%xmm1, %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str217, %edi
	movb	$1, %al
	callq	printf
	movl	$1066052266, -8(%rbp)           # imm = 0x3F8AAAAA
	movsd	.LCPI0_4(%rip), %xmm0           # xmm0 = mem[0],zero
	movl	$.L.str221, %edi
	movb	$1, %al
	callq	printf
	xorps	%xmm0, %xmm0
	subss	-8(%rbp), %xmm0
	movss	%xmm0, -8(%rbp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.L.str227, %edi
	movb	$1, %al
	callq	printf
	movq	%rsp, %rax
	leaq	-16(%rax), %rsp
	movl	$1100554636, -16(%rax)          # imm = 0x4199218C
	movsd	.LCPI0_5(%rip), %xmm0           # xmm0 = mem[0],zero
	movl	$.L.str232, %edi
	movb	$1, %al
	callq	printf
	movl	$.L.str235, %edi
	xorl	%eax, %eax
	callq	printf
	leaq	-4(%rbp), %rsi
	movl	$.L.str237, %edi
	xorl	%eax, %eax
	callq	scanf
	movl	-4(%rbp), %esi
	movl	$.L.str240, %edi
	xorl	%eax, %eax
	callq	printf
	cmpl	$601, -4(%rbp)                  # imm = 0x259
	jl	.LBB0_13
# %bb.12:                               # %L18
	movl	$.L.str244, %edi
	jmp	.LBB0_14
.LBB0_13:                               # %L19
	movl	$.L.str246, %edi
.LBB0_14:                               # %L17
	xorl	%eax, %eax
	callq	printf
	xorl	%eax, %eax
	movq	%rbp, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str11,@object                # @.str11
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str11:
	.asciz	"a=%d\n"
	.size	.L.str11, 6

	.type	.L.str19,@object                # @.str19
.L.str19:
	.asciz	"a=%d\n"
	.size	.L.str19, 6

	.type	.L.str28,@object                # @.str28
.L.str28:
	.asciz	"a=%d\n"
	.size	.L.str28, 6

	.type	.L.str30,@object                # @.str30
.L.str30:
	.asciz	"printf test\n"
	.size	.L.str30, 13

	.type	.L.str33,@object                # @.str33
.L.str33:
	.asciz	"a=%d\n"
	.size	.L.str33, 6

	.type	.L.str39,@object                # @.str39
.L.str39:
	.asciz	"a=%d\n"
	.size	.L.str39, 6

	.type	.L.str44,@object                # @.str44
.L.str44:
	.asciz	"a=%d\n"
	.size	.L.str44, 6

	.type	.L.str49,@object                # @.str49
.L.str49:
	.asciz	"a=%d\n"
	.size	.L.str49, 6

	.type	.L.str52,@object                # @.str52
.L.str52:
	.asciz	"a=%d\n"
	.size	.L.str52, 6

	.type	.L.str58,@object                # @.str58
.L.str58:
	.asciz	"a=%d\n"
	.size	.L.str58, 6

	.type	.L.str63,@object                # @.str63
.L.str63:
	.asciz	"a=%d\n"
	.size	.L.str63, 6

	.type	.L.str68,@object                # @.str68
.L.str68:
	.asciz	"a=%d\n"
	.size	.L.str68, 6

	.type	.L.str71,@object                # @.str71
.L.str71:
	.asciz	"a=%d\n"
	.size	.L.str71, 6

	.type	.L.str77,@object                # @.str77
.L.str77:
	.asciz	"a=%d\n"
	.size	.L.str77, 6

	.type	.L.str82,@object                # @.str82
.L.str82:
	.asciz	"a=%d\n"
	.size	.L.str82, 6

	.type	.L.str87,@object                # @.str87
.L.str87:
	.asciz	"a=%d\n"
	.size	.L.str87, 6

	.type	.L.str90,@object                # @.str90
.L.str90:
	.asciz	"a=%d\n"
	.size	.L.str90, 6

	.type	.L.str96,@object                # @.str96
.L.str96:
	.asciz	"a=%d\n"
	.size	.L.str96, 6

	.type	.L.str101,@object               # @.str101
.L.str101:
	.asciz	"a=%d\n"
	.size	.L.str101, 6

	.type	.L.str106,@object               # @.str106
.L.str106:
	.asciz	"a=%d\n"
	.size	.L.str106, 6

	.type	.L.str109,@object               # @.str109
.L.str109:
	.asciz	"a=%d\n"
	.size	.L.str109, 6

	.type	.L.str114,@object               # @.str114
.L.str114:
	.asciz	"a=%d\n"
	.size	.L.str114, 6

	.type	.L.str120,@object               # @.str120
.L.str120:
	.asciz	"f=%f\n"
	.size	.L.str120, 6

	.type	.L.str128,@object               # @.str128
.L.str128:
	.asciz	"f=%f\n"
	.size	.L.str128, 6

	.type	.L.str136,@object               # @.str136
.L.str136:
	.asciz	"f=%f\n"
	.size	.L.str136, 6

	.type	.L.str140,@object               # @.str140
.L.str140:
	.asciz	"f=%f\n"
	.size	.L.str140, 6

	.type	.L.str147,@object               # @.str147
.L.str147:
	.asciz	"f=%f\n"
	.size	.L.str147, 6

	.type	.L.str155,@object               # @.str155
.L.str155:
	.asciz	"f=%f\n"
	.size	.L.str155, 6

	.type	.L.str163,@object               # @.str163
.L.str163:
	.asciz	"f=%f\n"
	.size	.L.str163, 6

	.type	.L.str167,@object               # @.str167
.L.str167:
	.asciz	"f=%f\n"
	.size	.L.str167, 6

	.type	.L.str174,@object               # @.str174
.L.str174:
	.asciz	"f=%f\n"
	.size	.L.str174, 6

	.type	.L.str182,@object               # @.str182
.L.str182:
	.asciz	"f=%f\n"
	.size	.L.str182, 6

	.type	.L.str190,@object               # @.str190
.L.str190:
	.asciz	"f=%f\n"
	.size	.L.str190, 6

	.type	.L.str194,@object               # @.str194
.L.str194:
	.asciz	"f=%f\n"
	.size	.L.str194, 6

	.type	.L.str201,@object               # @.str201
.L.str201:
	.asciz	"f=%f\n"
	.size	.L.str201, 6

	.type	.L.str209,@object               # @.str209
.L.str209:
	.asciz	"f=%f\n"
	.size	.L.str209, 6

	.type	.L.str217,@object               # @.str217
.L.str217:
	.asciz	"f=%f\n"
	.size	.L.str217, 6

	.type	.L.str221,@object               # @.str221
.L.str221:
	.asciz	"f=%f\n"
	.size	.L.str221, 6

	.type	.L.str227,@object               # @.str227
.L.str227:
	.asciz	"f=%f\n"
	.size	.L.str227, 6

	.type	.L.str232,@object               # @.str232
.L.str232:
	.asciz	"count=%f\n"
	.size	.L.str232, 10

	.type	.L.str235,@object               # @.str235
.L.str235:
	.asciz	"scanf test input int:\n"
	.size	.L.str235, 23

	.type	.L.str237,@object               # @.str237
.L.str237:
	.asciz	"%d"
	.size	.L.str237, 3

	.type	.L.str240,@object               # @.str240
.L.str240:
	.asciz	"input=%d\n"
	.size	.L.str240, 10

	.type	.L.str244,@object               # @.str244
.L.str244:
	.asciz	"a>600\n"
	.size	.L.str244, 7

	.type	.L.str246,@object               # @.str246
.L.str246:
	.asciz	"a<=600\n"
	.size	.L.str246, 8

	.section	".note.GNU-stack","",@progbits
