#### 题目描述

给出```n```代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 ```n = 3```，生成结果为：

>   [     
        "((()))",   
        "(()())",   
        "(())()",   
        "()(())",   
        "()()()"    
    ]



#### 思路

利用```回溯法```，穷举所有的组合，对于每一个组合利用 ```Stack``` 验证其有效性。

这种方法效率有点低。

看了 leetcode 中的一个答案非常简洁，技巧非常巧妙，但是要理解这段代码还是要花费不少功夫，这里面涉及到了很多复杂的递归。

不过要是把这段代码能够完整地在脑子里面“跑”一遍，理解一般的递归应该也没有什么问题了吧!


[代码参考](https://github.com/leexuehan/algorithmpractice/blob/master/src/main/java/leetcode/pro10/ParentheseSolution2.java)

这段代码巧妙在：添加左括号、右括号的时候，同时避免了如何去验证括号是否有效的问题，始终能保持左右括号数量是一致的。

以括号对数n=3为例:

    left = 1---->"("
        left < n ? => 
            left = 2 ---->"(("
                left < n ? =>
                    left = 3 ---->"((("
                        right < left ? =>
                            right = 1---->"((()"
                        right < left ? =>
                            right = 2---->"((())"
                        right < left ? =>
                            right = 3----->"((()))"
                            right == left? => output 
                right < left ? => 
                    right = 1 ---->"(()"
                        left < n ? => 
                            left = 3 ---> "(()("
                                right < left ? =>
                                    right = 2 ---->"(()()"
                                        right < left ? =>
                                            right = 3 ----> "(()())"
                                        right == left? => output
                        right < left ? =>
                            right = 2 ---> "(())"
                                left < n ? =>
                                    left = 3 ---> "(())("
                                        right < left ? => 
                                            right = 3 --->"(())()"
                                                left == right ? => output
                                                
                        ..........
                
            
                
                    

