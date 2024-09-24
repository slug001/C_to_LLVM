; === prologue ====
declare dso_local i32 @printf(i8*, ...)

declare dso_local i32 @scanf(i8*, ...)

define dso_local i32 @main()
{
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
%t3 = alloca float, align 4
%t4 = alloca float, align 4
%t5 = alloca i8, align 1
%t6 = alloca i8, align 1
store i32 6, i32* %t1, align 4
store i32 -9, i32* %t2, align 4
%t7 = load i32, i32* %t1, align 4
%t8 = sub nsw i32 0, %t7
store i32 %t8, i32* %t2, align 4
%t9 = load i32, i32* %t1, align 4
%t10 = load i32, i32* %t1, align 4
%t11 = mul nsw i32 %t9, %t10
%t12 = load i32, i32* %t2, align 4
%t13 = sdiv i32 %t11, %t12
store i32 %t13, i32* %t2, align 4
%t14 = load i32, i32* %t1, align 4
%t15 = mul nsw i32 %t14, 2
store i32 %t15, i32* %t2, align 4
%t16 = load i32, i32* %t1, align 4
%t17 = mul nsw i32 2, %t16
store i32 %t17, i32* %t2, align 4
store i32 4, i32* %t2, align 4
%t18 = load i32, i32* %t1, align 4
%t19 = load i32, i32* %t1, align 4
%t20 = sdiv i32 %t18, %t19
store i32 %t20, i32* %t2, align 4
%t21 = load i32, i32* %t1, align 4
%t22 = sdiv i32 %t21, 2
store i32 %t22, i32* %t2, align 4
%t23 = load i32, i32* %t1, align 4
%t24 = sdiv i32 3, %t23
store i32 %t24, i32* %t2, align 4
store i32 0, i32* %t2, align 4
%t25 = load i32, i32* %t1, align 4
%t26 = load i32, i32* %t1, align 4
%t27 = add nsw i32 %t25, %t26
store i32 %t27, i32* %t2, align 4
%t28 = load i32, i32* %t1, align 4
%t29 = add nsw i32 %t28, 1
store i32 %t29, i32* %t2, align 4
%t30 = load i32, i32* %t1, align 4
%t31 = add nsw i32 2, %t30
store i32 %t31, i32* %t2, align 4
store i32 7, i32* %t2, align 4
%t32 = load i32, i32* %t1, align 4
%t33 = load i32, i32* %t1, align 4
%t34 = add nsw i32 %t32, %t33
store i32 %t34, i32* %t2, align 4
%t35 = load i32, i32* %t1, align 4
%t36 = sub nsw i32 %t35, 1
store i32 %t36, i32* %t2, align 4
%t37 = load i32, i32* %t1, align 4
%t38 = sub nsw i32 2, %t37
store i32 %t38, i32* %t2, align 4
store i32 -1, i32* %t2, align 4
store i32 58, i32* %t1, align 4

; === epilogue ===
ret i32 0
}
