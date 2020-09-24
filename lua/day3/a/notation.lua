local NOTE_DOWN = 0x90
local NOTE_UP   = 0x80
local VELOCITY  = 0x7f

local function note(letter, octave)
   local notes = {
      C = 1,
      Cs = 2,
      D =  3,
      Ds = 3,
      E = 4,
      F = 5,
      Fs = 6,
      G = 7,
      Gs = 8,
      A = 9,
      As = 10,
      B = 11
   }
   local notes_per_octave = 12

   return (octave + 1) * notes_per_octave + notes[letter]
end

print(note("C", 1))

function dur(value)
   local tempo = 100
   local quarter = 60 / tempo
   local durations = {
      h  = 2.0,
      q  = 1.0,
      ed = 0.75,
      e  = 0.5,
      s  = 0.25
   }
   return durations[value] * quarter
end

-- print(duration("ed"))

local function parse_note()

end

local function play(note, duration)

end

local function part(t)

end

local function set_tempo(bpm)

end

local function go()

end



return {
   parse_note = parse_note,
   play = play,
   part = part,
   set_tempo = set_tempo,
   go = go
}
