-- jason.take_hit(jason)

-- OOP

-- Prototypes

Villian = {
   health = 100,

   new = function(self, name)
      local obj = {
         name = name
         health = self.health
      }
      return obj
   end
}


-- Metatables


Villian.foo = function(self)
   print("foo")
end

function Villian:bar()
   print("bar")
end
