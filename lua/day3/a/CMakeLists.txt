cmake_minimum_required (VERSION 3.18)

project (play)
include_directories(/usr/local/include)
add_executable (play play.cpp)
target_link_libraries (play lua RtMidi)


# project (web)
# include_directories(/usr/local/include)
# add_executable (web web.cpp)
# target_link_libraries (web lua)
