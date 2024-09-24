@.str8 = private unnamed_addr constant [21 x i8] c"a is greater than b\0A\00", align 1
@.str10 = private unnamed_addr constant [27 x i8] c"a is grater or equal to b\0A\00", align 1
@.str16 = private unnamed_addr constant [12 x i8] c"a + b = %d\0A\00", align 1
@.str32 = private unnamed_addr constant [10 x i8] c"res = %d\0A\00", align 1
@.str36 = private unnamed_addr constant [36 x i8] c"res is less than or equal to 69420\0A\00", align 1
@.str38 = private unnamed_addr constant [27 x i8] c"res is greater than 69420\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)

declare dso_local i32 @scanf(i8*, ...)

define dso_local i32 @main()
{
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
%t3 = alloca i32, align 4
%t4 = alloca i32, align 4
store i32 80, i32* %t1, align 4
store i32 90, i32* %t2, align 4
%t5= load i32, i32* %t1, align 4
%t6= load i32, i32* %t2, align 4
%t7 = icmp sgt i32 %t5, %t6
br i1 %t7, label %L2, label %L3
L2:
%t9 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([21 x i8], [21 x i8]* @.str8, i64 0, i64 0))
br label %L1
L3:
%t11 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([27 x i8], [27 x i8]* @.str10, i64 0, i64 0))
br label %L1
L1:
%t12 = load i32, i32* %t1, align 4
%t13 = load i32, i32* %t2, align 4
%t14 = add nsw i32 %t12, %t13
store i32 %t14, i32* %t3, align 4
%t15 = load i32, i32* %t3, align 4
%t17 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([12 x i8], [12 x i8]* @.str16, i64 0, i64 0), i32 noundef %t15)
%t18 = load i32, i32* %t1, align 4
%t19 = add nsw i32 %t18, 1
%t20 = load i32, i32* %t2, align 4
%t21 = sub nsw i32 %t20, 1
%t22 = mul nsw i32 %t19, %t21
%t23 = sdiv i32 %t22, 4
%t24 = mul nsw i32 %t23, 5
%t25 = load i32, i32* %t2, align 4
%t26 = sub nsw i32 %t24, %t25
%t27 = add nsw i32 %t26, 1
%t28 = load i32, i32* %t1, align 4
%t29 = mul nsw i32 4, %t28
%t30 = add nsw i32 %t27, %t29
store i32 %t30, i32* %t4, align 4
%t31 = load i32, i32* %t4, align 4
%t33 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([10 x i8], [10 x i8]* @.str32, i64 0, i64 0), i32 noundef %t31)
%t34= load i32, i32* %t4, align 4
%t35 = icmp sle i32 %t34, 69420
br i1 %t35, label %L6, label %L7
L6:
%t37 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([36 x i8], [36 x i8]* @.str36, i64 0, i64 0))
br label %L5
L7:
%t39 = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([27 x i8], [27 x i8]* @.str38, i64 0, i64 0))
br label %L5
L5:

; === epilogue ===
ret i32 0
}
