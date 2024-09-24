@.str6 = private unnamed_addr constant [5 x i8] c"a>b\0A\00", align 1
@.str11 = private unnamed_addr constant [6 x i8] c"a==b\0A\00", align 1
@.str16 = private unnamed_addr constant [5 x i8] c"a<b\0A\00", align 1
@.str18 = private unnamed_addr constant [5 x i8] c"bad\0A\00", align 1
@.str23 = private unnamed_addr constant [7 x i8] c"equal\0A\00", align 1
@.str34 = private unnamed_addr constant [6 x i8] c"hehe\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)

declare dso_local i32 @scanf(i8*, ...)

define dso_local i32 @main()
{
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
store i32 6, i32* %t1, align 4
store i32 3, i32* %t2, align 4
%t3= load i32, i32* %t1, align 4
%t4= load i32, i32* %t2, align 4
%t5 = icmp sgt i32 %t3, %t4
br i1 %t5, label %L2, label %L3
L2:
%t7 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([5 x i8], [5 x i8]* @.str6, i64 0, i64 0))
br label %L1
L3:
%t8= load i32, i32* %t1, align 4
%t9= load i32, i32* %t2, align 4
%t10 = icmp eq i32 %t8, %t9
br i1 %t10, label %L5, label %L6
L5:
%t12 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str11, i64 0, i64 0))
br label %L4
L6:
%t13= load i32, i32* %t1, align 4
%t14= load i32, i32* %t2, align 4
%t15 = icmp slt i32 %t13, %t14
br i1 %t15, label %L8, label %L9
L8:
%t17 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([5 x i8], [5 x i8]* @.str16, i64 0, i64 0))
br label %L7
L9:
%t19 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([5 x i8], [5 x i8]* @.str18, i64 0, i64 0))
br label %L7
L7:
br label %L4
L4:
br label %L1
L1:
%t20= load i32, i32* %t1, align 4
%t21= load i32, i32* %t2, align 4
%t22 = icmp sgt i32 %t20, %t21
br i1 %t22, label %L12, label %L13
L12:
%t24 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([7 x i8], [7 x i8]* @.str23, i64 0, i64 0))
br label %L13
L13:
%t25= load i32, i32* %t1, align 4
%t26= load i32, i32* %t2, align 4
%t27 = icmp sgt i32 %t25, %t26
br i1 %t27, label %L15, label %L16
L15:
%t28= load i32, i32* %t1, align 4
%t29= load i32, i32* %t2, align 4
%t30 = icmp sgt i32 %t28, %t29
br i1 %t30, label %L18, label %L19
L18:
%t31= load i32, i32* %t1, align 4
%t32= load i32, i32* %t2, align 4
%t33 = icmp sgt i32 %t31, %t32
br i1 %t33, label %L21, label %L22
L21:
%t35 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([6 x i8], [6 x i8]* @.str34, i64 0, i64 0))
br label %L22
L22:
br label %L19
L19:
br label %L16
L16:

; === epilogue ===
ret i32 0
}
