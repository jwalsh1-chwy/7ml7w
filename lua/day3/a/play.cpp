extern "C"
{
#include "lua.h"
#include "luaxlib.h"
#include "lualib.h"
}


int main(int argc, const char* argv[])
{
  lua_State* L = luaL_newstate();
  luaL_openlibs(L);

  luaL_dostring(L, "print('Hello')");

  lua_close(L);
  return 0;
}
