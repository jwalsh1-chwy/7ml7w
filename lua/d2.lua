book = {
   title = 'Seven More Languages in Seven Weeks',
   author = 'Bruce A. Tate',
   pages = 291
}


print(book)

book.author = book.author

function print_kv(k, v)
   print(k .. ": " .. v)
end

-- iterators
function print_table(table)
   for k, v in pairs(table) do
      print_kv(k, v)
   end
end

book.stars = 5

print_table(book)

-- Array with indexing
medals = {
   "gold",
   "silver",
   "bronze"
}

medals[4] = "lead"

print_table(medals)

-- Dictionary
ice_cream_scoops = {
   "vanilla",
   "chocolate";
   sprinkles = true
}

-- provides table_to_string
dofile('util.lua')


-- provides mt
dofile('strict.lua')



print(table_to_string(medals))

--  read and write
treasure = {}
setmetatable(treasure, mt)


jason = {
   name = 'Jason Walsh',
   health = 100
}

-- jason.take_hit(jason)
