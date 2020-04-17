-- 这是单行注释

--[[
 这是多行注释
]]

--1
--print("hello lua")

--2
--[[
function fact (n)
    if n == 0 then
        return 1
    else
        return n * fact(n-1)
    end
end
--print("enter a number")
--a =io.read("*number")
print(fact(4))
--]]

--3
--[[
print(b)
b=12
print(b)
--]]

--4 type
--[[
print(type("hello lua"))
print(type(10.4*3))
print(type(type))
print(type(print))
print(type(true))
print(type(nil))
print(type(type(X)))
--]]

--5 string
--[[
a = "one string"
b = string.gsub(a,"one","another")
print(a)
print(b)
print("one line\nnext line\n\"in quotes\",'in quotes'")

print(#a)
]]

--6 table
a = {}
a["x"]=10
a[22]="some string"
print(a["x"])
print(a[22])
print(a[3])
print(a.x)
b = {}
b[1]="q"
b[2]="w"
b[3]="e"
print(b[#b])


