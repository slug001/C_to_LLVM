@.str11 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str19 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str28 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str30 = private unnamed_addr constant [13 x i8] c"printf test\0A\00", align 1
@.str33 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str39 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str44 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str49 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str52 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str58 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str63 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str68 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str71 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str77 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str82 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str87 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str90 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str96 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str101 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str106 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str109 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str114 = private unnamed_addr constant [6 x i8] c"a=%d\0A\00", align 1
@.str120 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str128 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str136 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str140 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str147 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str155 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str163 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str167 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str174 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str182 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str190 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str194 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str201 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str209 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str217 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str221 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str227 = private unnamed_addr constant [6 x i8] c"f=%f\0A\00", align 1
@.str232 = private unnamed_addr constant [10 x i8] c"count=%f\0A\00", align 1
@.str235 = private unnamed_addr constant [23 x i8] c"scanf test input int:\0A\00", align 1
@.str237 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str240 = private unnamed_addr constant [10 x i8] c"input=%d\0A\00", align 1
@.str244 = private unnamed_addr constant [7 x i8] c"a>600\0A\00", align 1
@.str246 = private unnamed_addr constant [8 x i8] c"a<=600\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)

declare dso_local i32 @scanf(i8*, ...)

define dso_local i32 @main()
{
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
%t3 = alloca float, align 4
%t4 = alloca float, align 4
store float 0x3ff3333340000000, float* %t3, align 4
store i32 0, i32* %t1, align 4
store i32 3, i32* %t2, align 4
br label %L2
L2:
%t5= load i32, i32* %t1, align 4
%t6= load i32, i32* %t2, align 4
%t7 = icmp slt i32 %t5, %t6
br i1 %t7, label %L3, label %L4
L3:
%t8 = load i32, i32* %t1, align 4
%t9 = add nsw i32 %t8, 1
store i32 %t9, i32* %t1, align 4
br label %L2
L4:
%t10 = load i32, i32* %t1, align 4
%t12 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str11, i64 0, i64 0), i32 noundef %t10)
store i32 10, i32* %t2, align 4
br label %L6
L6:
%t13= load i32, i32* %t1, align 4
%t14= load i32, i32* %t2, align 4
%t15 = icmp slt i32 %t13, %t14
br i1 %t15, label %L7, label %L8
L7:
%t16 = load i32, i32* %t1, align 4
%t17 = add nsw i32 %t16, 1
store i32 %t17, i32* %t1, align 4
br label %L6
L8:
%t18 = load i32, i32* %t1, align 4
%t20 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str19, i64 0, i64 0), i32 noundef %t18)
store i32 1, i32* %t1, align 4
br label %L11
L11:
%t21= load i32, i32* %t1, align 4
%t22 = icmp slt i32 %t21, 5
br i1  %t22, label %L10, label %L13
L12:
%t23 = load i32, i32* %t1, align 4
%t24 = add nsw i32 %t23, 1
store i32 %t24, i32* %t1, align 4
br label %L11
L10:
%t25= load i32, i32* %t1, align 4
%t26 = icmp sgt i32 %t25, 2
br i1 %t26, label %L15, label %L16
L15:
%t27 = load i32, i32* %t1, align 4
%t29 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str28, i64 0, i64 0), i32 noundef %t27)
br label %L16
L16:
br label %L12
L13:
%t31 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([13 x i8], [13 x i8]* @.str30, i64 0, i64 0))
%t32 = load i32, i32* %t1, align 4
%t34 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str33, i64 0, i64 0), i32 noundef %t32)
%t35 = load i32, i32* %t1, align 4
%t36 = load i32, i32* %t1, align 4
%t37 = add nsw i32 %t35, %t36
store i32 %t37, i32* %t1, align 4
%t38 = load i32, i32* %t1, align 4
%t40 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str39, i64 0, i64 0), i32 noundef %t38)
%t41 = load i32, i32* %t1, align 4
%t42 = add nsw i32 %t41, 1
store i32 %t42, i32* %t1, align 4
%t43 = load i32, i32* %t1, align 4
%t45 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str44, i64 0, i64 0), i32 noundef %t43)
%t46 = load i32, i32* %t1, align 4
%t47 = add nsw i32 1, %t46
store i32 %t47, i32* %t1, align 4
%t48 = load i32, i32* %t1, align 4
%t50 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str49, i64 0, i64 0), i32 noundef %t48)
store i32 2, i32* %t1, align 4
%t51 = load i32, i32* %t1, align 4
%t53 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str52, i64 0, i64 0), i32 noundef %t51)
%t54 = load i32, i32* %t1, align 4
%t55 = load i32, i32* %t1, align 4
%t56 = sub nsw i32 %t54, %t55
store i32 %t56, i32* %t1, align 4
%t57 = load i32, i32* %t1, align 4
%t59 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str58, i64 0, i64 0), i32 noundef %t57)
%t60 = load i32, i32* %t1, align 4
%t61 = sub nsw i32 %t60, 1
store i32 %t61, i32* %t1, align 4
%t62 = load i32, i32* %t1, align 4
%t64 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str63, i64 0, i64 0), i32 noundef %t62)
%t65 = load i32, i32* %t1, align 4
%t66 = sub nsw i32 1, %t65
store i32 %t66, i32* %t1, align 4
%t67 = load i32, i32* %t1, align 4
%t69 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str68, i64 0, i64 0), i32 noundef %t67)
store i32 2, i32* %t1, align 4
%t70 = load i32, i32* %t1, align 4
%t72 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str71, i64 0, i64 0), i32 noundef %t70)
%t73 = load i32, i32* %t1, align 4
%t74 = load i32, i32* %t1, align 4
%t75 = mul nsw i32 %t73, %t74
store i32 %t75, i32* %t1, align 4
%t76 = load i32, i32* %t1, align 4
%t78 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str77, i64 0, i64 0), i32 noundef %t76)
%t79 = load i32, i32* %t1, align 4
%t80 = mul nsw i32 %t79, 2
store i32 %t80, i32* %t1, align 4
%t81 = load i32, i32* %t1, align 4
%t83 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str82, i64 0, i64 0), i32 noundef %t81)
%t84 = load i32, i32* %t1, align 4
%t85 = mul nsw i32 2, %t84
store i32 %t85, i32* %t1, align 4
%t86 = load i32, i32* %t1, align 4
%t88 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str87, i64 0, i64 0), i32 noundef %t86)
store i32 2, i32* %t1, align 4
%t89 = load i32, i32* %t1, align 4
%t91 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str90, i64 0, i64 0), i32 noundef %t89)
%t92 = load i32, i32* %t1, align 4
%t93 = load i32, i32* %t1, align 4
%t94 = sdiv i32 %t92, %t93
store i32 %t94, i32* %t1, align 4
%t95 = load i32, i32* %t1, align 4
%t97 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str96, i64 0, i64 0), i32 noundef %t95)
store i32 10, i32* %t1, align 4
%t98 = load i32, i32* %t1, align 4
%t99 = sdiv i32 %t98, 2
store i32 %t99, i32* %t1, align 4
%t100 = load i32, i32* %t1, align 4
%t102 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str101, i64 0, i64 0), i32 noundef %t100)
%t103 = load i32, i32* %t1, align 4
%t104 = sdiv i32 6, %t103
store i32 %t104, i32* %t1, align 4
%t105 = load i32, i32* %t1, align 4
%t107 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str106, i64 0, i64 0), i32 noundef %t105)
store i32 2, i32* %t1, align 4
%t108 = load i32, i32* %t1, align 4
%t110 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str109, i64 0, i64 0), i32 noundef %t108)
%t111 = load i32, i32* %t1, align 4
%t112 = sub nsw i32 0, %t111
store i32 %t112, i32* %t1, align 4
%t113 = load i32, i32* %t1, align 4
%t115 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str114, i64 0, i64 0), i32 noundef %t113)
store float 0x3ff3333340000000, float* %t3, align 4
store float 0x4003333340000000, float* %t4, align 4
%t116 = load float, float* %t3, align 4
%t117 = load float, float* %t3, align 4
%t118 = fadd float %t116, %t117
store float %t118, float* %t3, align 4
%t119 = load float, float* %t3, align 4
%t121 = fpext float %t119 to double
%t122 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str120, i64 0, i64 0), double noundef %t121)
%t123 = load float, float* %t3, align 4
%t124 = fpext float %t123 to double
%t125 = fadd double %t124, 1.2
%t126 = fptrunc double %t125 to float
store float %t126, float* %t3, align 4
%t127 = load float, float* %t3, align 4
%t129 = fpext float %t127 to double
%t130 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str128, i64 0, i64 0), double noundef %t129)
%t131 = load float, float* %t3, align 4
%t132 = fpext float %t131 to double
%t133 = fadd double 1.2, %t132
%t134 = fptrunc double %t133 to float
store float %t134, float* %t3, align 4
%t135 = load float, float* %t3, align 4
%t137 = fpext float %t135 to double
%t138 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str136, i64 0, i64 0), double noundef %t137)
store float 0x4003333340000000, float* %t3, align 4
%t139 = load float, float* %t3, align 4
%t141 = fpext float %t139 to double
%t142 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str140, i64 0, i64 0), double noundef %t141)
%t143 = load float, float* %t3, align 4
%t144 = load float, float* %t3, align 4
%t145 = fsub float %t143, %t144
store float %t145, float* %t3, align 4
%t146 = load float, float* %t3, align 4
%t148 = fpext float %t146 to double
%t149 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str147, i64 0, i64 0), double noundef %t148)
%t150 = load float, float* %t3, align 4
%t151 = fpext float %t150 to double
%t152 = fsub double %t151, 1.2
%t153 = fptrunc double %t152 to float
store float %t153, float* %t3, align 4
%t154 = load float, float* %t3, align 4
%t156 = fpext float %t154 to double
%t157 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str155, i64 0, i64 0), double noundef %t156)
%t158 = load float, float* %t3, align 4
%t159 = fpext float %t158 to double
%t160 = fsub double 1.2, %t159
%t161 = fptrunc double %t160 to float
store float %t161, float* %t3, align 4
%t162 = load float, float* %t3, align 4
%t164 = fpext float %t162 to double
%t165 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str163, i64 0, i64 0), double noundef %t164)
store float 0x3fb9999800000000, float* %t3, align 4
%t166 = load float, float* %t3, align 4
%t168 = fpext float %t166 to double
%t169 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str167, i64 0, i64 0), double noundef %t168)
%t170 = load float, float* %t3, align 4
%t171 = load float, float* %t3, align 4
%t172 = fmul float %t170, %t171
store float %t172, float* %t3, align 4
%t173 = load float, float* %t3, align 4
%t175 = fpext float %t173 to double
%t176 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str174, i64 0, i64 0), double noundef %t175)
%t177 = load float, float* %t3, align 4
%t178 = fpext float %t177 to double
%t179 = fmul double %t178, 1.2
%t180 = fptrunc double %t179 to float
store float %t180, float* %t3, align 4
%t181 = load float, float* %t3, align 4
%t183 = fpext float %t181 to double
%t184 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str182, i64 0, i64 0), double noundef %t183)
%t185 = load float, float* %t3, align 4
%t186 = fpext float %t185 to double
%t187 = fmul double 1.2, %t186
%t188 = fptrunc double %t187 to float
store float %t188, float* %t3, align 4
%t189 = load float, float* %t3, align 4
%t191 = fpext float %t189 to double
%t192 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str190, i64 0, i64 0), double noundef %t191)
store float 0x3ff8f5c2a0000000, float* %t3, align 4
%t193 = load float, float* %t3, align 4
%t195 = fpext float %t193 to double
%t196 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str194, i64 0, i64 0), double noundef %t195)
%t197 = load float, float* %t3, align 4
%t198 = load float, float* %t3, align 4
%t199 = fdiv float %t197, %t198
store float %t199, float* %t3, align 4
%t200 = load float, float* %t3, align 4
%t202 = fpext float %t200 to double
%t203 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str201, i64 0, i64 0), double noundef %t202)
%t204 = load float, float* %t3, align 4
%t205 = fpext float %t204 to double
%t206 = fdiv double %t205, 1.2
%t207 = fptrunc double %t206 to float
store float %t207, float* %t3, align 4
%t208 = load float, float* %t3, align 4
%t210 = fpext float %t208 to double
%t211 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str209, i64 0, i64 0), double noundef %t210)
%t212 = load float, float* %t3, align 4
%t213 = fpext float %t212 to double
%t214 = fdiv double 1.2, %t213
%t215 = fptrunc double %t214 to float
store float %t215, float* %t3, align 4
%t216 = load float, float* %t3, align 4
%t218 = fpext float %t216 to double
%t219 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str217, i64 0, i64 0), double noundef %t218)
store float 0x3ff1555540000000, float* %t3, align 4
%t220 = load float, float* %t3, align 4
%t222 = fpext float %t220 to double
%t223 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str221, i64 0, i64 0), double noundef %t222)
%t224 = load float, float* %t3, align 4
%t225 = fsub float 0.0, %t224
store float %t225, float* %t3, align 4
%t226 = load float, float* %t3, align 4
%t228 = fpext float %t226 to double
%t229 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str227, i64 0, i64 0), double noundef %t228)
%t230 = alloca float, align 4
store float 0x4033243180000000, float* %t230, align 4
%t231 = load float, float* %t230, align 4
%t233 = fpext float %t231 to double
%t234 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([10 x i8], [10 x i8]* @.str232, i64 0, i64 0), double noundef %t233)
%t236 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([23 x i8], [23 x i8]* @.str235, i64 0, i64 0))
%t238 = call i32 (i8*, ...) @scanf(i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str237, i64 0, i64 0), i32* noundef %t1)
%t239 = load i32, i32* %t1, align 4
%t241 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([10 x i8], [10 x i8]* @.str240, i64 0, i64 0), i32 noundef %t239)
%t242= load i32, i32* %t1, align 4
%t243 = icmp sgt i32 %t242, 600
br i1 %t243, label %L18, label %L19
L18:
%t245 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([7 x i8], [7 x i8]* @.str244, i64 0, i64 0))
br label %L17
L19:
%t247 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([8 x i8], [8 x i8]* @.str246, i64 0, i64 0))
br label %L17
L17:

; === epilogue ===
ret i32 0
}
