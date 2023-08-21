def mymax(iterable, key = lambda value: value):
  # incijaliziraj maksimalni element i maksimalni ključ
  max_x=max_key=None
  maxIndex = len(iterable) - 1
  # obiđi sve elemente
  for x in iterable:
    # ako je key(x) najveći -> ažuriraj max_x i max_key
    if (max_key == None or key(x) > max_key):
      max_x = x
      max_key = key(max_x)
  # vrati rezultat
  return max_x

# with explicitly defined key function
maxint = mymax([1, 3, 5, 7, 4, 6, 9, 2, 0], lambda x: x)
maxchar = mymax("Suncana strana ulice", lambda ch: ch)
maxstring = mymax([
  "Gle", "malu", "vocku", "poslije", "kise",
  "Puna", "je", "kapi", "pa", "ih", "njise"], lambda word: len(word))

print(maxint)
print(maxchar)
print(maxstring)

# without explicitly defined key function
maxint = mymax([1, 3, 5, 7, 4, 6, 9, 2, 0])
maxchar = mymax("Suncana strana ulice")
maxstring = mymax([
  "Gle", "malu", "vocku", "poslije", "kise",
  "Puna", "je", "kapi", "pa", "ih", "njise"])

D={'burek':8, 'buhtla':5}
maxpastrycost = mymax(D, lambda name: D.get(name))

people = [('Ana', 'Anić'), ('Zrinka', 'Zrinski'), ('Ana', 'Ančić')]
lastpersonlcg = mymax(people)

print(maxint)
print(maxchar)
print(maxstring)
print(maxpastrycost)
print(lastpersonlcg)