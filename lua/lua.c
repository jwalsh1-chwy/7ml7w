#include <stdlib.h>
#include <stdio.h>

#include "lua.h"
#include "lauxlib.h"
#include "lualib.h"

int lua_main(const char *script)
{
  int status, result;
  lua_State *L = luaL_newstate(); /* create state */
  if (L == NULL)
    {
      printf("lua: cannot create state: not enough memory\n");
      return 1;
    }
  luaL_openlibs(L);
  status = luaL_dostring(L, script);
  if (status != LUA_OK)
    {
      const char *msg = lua_tostring(L, -1);
      printf("lua: %s\n", msg);
      lua_close(L);
      return EXIT_FAILURE;
    }
  result = lua_toboolean(L, -1);
  lua_close(L);
  return result ? EXIT_SUCCESS : EXIT_FAILURE;
}
