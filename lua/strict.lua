local __private = {}

function strict_read(table, key)
   if private[key] then
      return __private[key]
   else
      error('Invalid key: ' .. key)
   end
end

function strict_write(table, key, value)
   if private[key] then
      error('Duplicate key:' .. key)
   else
      __private[key] = value
   end
end

mt =  {
   __index = strict_read,
   __newindex = strict_write
}
