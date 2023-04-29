let SessionLoad = 1
let s:so_save = &g:so | let s:siso_save = &g:siso | setg so=0 siso=0 | setl so=-1 siso=-1
let v:this_session=expand("<sfile>:p")
silent only
silent tabonly
cd ~/homework/6sem/pis/program/cinema
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
let s:shortmess_save = &shortmess
if &shortmess =~ 'A'
  set shortmess=aoOA
else
  set shortmess=aoO
endif
badd +5 src/test/java/com/pjp/cinema/CinemaApplicationTests.java
badd +43 src/main/java/com/pjp/cinema/dto/User.java
badd +1 src/main/java/com/pjp/cinema/dto/Auditorium.java
badd +29 src/main/java/com/pjp/cinema/dto/Seat.java
badd +20 src/main/java/com/pjp/cinema/dto/Genre.java
badd +30 src/main/java/com/pjp/cinema/dto/Movie.java
badd +19 src/main/java/com/pjp/cinema/dto/Status.java
badd +33 src/main/java/com/pjp/cinema/dto/MovieSession.java
badd +141 src/main/java/com/pjp/cinema/web/PJPController.java
badd +1 src/main/java/com/pjp/cinema/data/AuditoriumRepository.java
badd +1 src/main/java/com/pjp/cinema/data/GenreRepository.java
badd +12 src/main/java/com/pjp/cinema/data/MovieRepository.java
badd +10 src/main/java/com/pjp/cinema/data/MovieSessionRepository.java
badd +9 src/main/java/com/pjp/cinema/data/SeatRepository.java
badd +9 src/main/java/com/pjp/cinema/data/StatusRepository.java
badd +13 src/main/java/com/pjp/cinema/data/UserRepository.java
badd +2 pom.xml
badd +59 src/main/java/com/pjp/cinema/web/services/UserService.java
badd +33 src/main/java/com/pjp/cinema/web/services/GenreService.java
badd +35 src/main/java/com/pjp/cinema/web/services/MovieSessionService.java
badd +70 src/main/java/com/pjp/cinema/web/services/MovieService.java
badd +39 src/main/java/com/pjp/cinema/web/services/SeatService.java
badd +33 src/main/java/com/pjp/cinema/web/services/StatusService.java
badd +1 src/main/java/com/pjp/cinema/web/services/AuditoriumService.java
badd +51 src/main/java/com/pjp/cinema/dto/UserLogin.java
badd +1 jdt://contents/java.base/java.util/List.class\?=cinema/\%5C/usr\%5C/lib\%5C/jvm\%5C/java-19-openjdk\%5C/lib\%5C/jrt-fs.jar\%60java.base=/javadoc_location=/https:\%5C/\%5C/docs.oracle.com\%5C/en\%5C/java\%5C/javase\%5C/19\%5C/docs\%5C/api\%5C/=/=/maven.pomderived=/true=/\%3Cjava.util(List.class
badd +18 src/main/java/com/pjp/cinema/web/PJPAdvices.java
badd +85 src/main/java/com/pjp/cinema/configurations/PJPConfiguration.java
badd +16 src/main/java/com/pjp/cinema/configurations/PJPAdvices.java
badd +22 src/main/java/com/pjp/cinema/dto/Cover.java
badd +9 src/main/java/com/pjp/cinema/data/CoverRepository.java
badd +43 jdt://contents/spring-data-commons-3.0.4.jar/org.springframework.data.repository/CrudRepository.class\?=cinema/\%5C/home\%5C/thesr\%5C/.m2\%5C/repository\%5C/org\%5C/springframework\%5C/data\%5C/spring-data-commons\%5C/3.0.4\%5C/spring-data-commons-3.0.4.jar=/maven.pomderived=/true=/=/javadoc_location=/jar:file:\%5C/home\%5C/thesr\%5C/.m2\%5C/repository\%5C/org\%5C/springframework\%5C/data\%5C/spring-data-commons\%5C/3.0.4\%5C/spring-data-commons-3.0.4-javadoc.jar\%5C\!\%5C/=/=/maven.groupId=/org.springframework.data=/=/maven.artifactId=/spring-data-commons=/=/maven.version=/3.0.4=/=/maven.scope=/compile=/=/maven.pomderived=/true=/\%3Corg.springframework.data.repository(CrudRepository.class
argglobal
%argdel
edit src/main/java/com/pjp/cinema/dto/Movie.java
let s:save_splitbelow = &splitbelow
let s:save_splitright = &splitright
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd w
let &splitbelow = s:save_splitbelow
let &splitright = s:save_splitright
wincmd t
let s:save_winminheight = &winminheight
let s:save_winminwidth = &winminwidth
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
exe 'vert 1resize ' . ((&columns * 83 + 87) / 174)
exe 'vert 2resize ' . ((&columns * 90 + 87) / 174)
argglobal
balt src/main/java/com/pjp/cinema/configurations/PJPConfiguration.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 30 - ((23 * winheight(0) + 21) / 43)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 30
normal! 033|
lcd ~/homework/6sem/pis/program/cinema
wincmd w
argglobal
if bufexists(fnamemodify("~/homework/6sem/pis/program/cinema/src/main/java/com/pjp/cinema/dto/MovieSession.java", ":p")) | buffer ~/homework/6sem/pis/program/cinema/src/main/java/com/pjp/cinema/dto/MovieSession.java | else | edit ~/homework/6sem/pis/program/cinema/src/main/java/com/pjp/cinema/dto/MovieSession.java | endif
if &buftype ==# 'terminal'
  silent file ~/homework/6sem/pis/program/cinema/src/main/java/com/pjp/cinema/dto/MovieSession.java
endif
balt ~/homework/6sem/pis/program/cinema/src/main/java/com/pjp/cinema/dto/Movie.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 33 - ((22 * winheight(0) + 21) / 43)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 33
normal! 016|
wincmd w
exe 'vert 1resize ' . ((&columns * 83 + 87) / 174)
exe 'vert 2resize ' . ((&columns * 90 + 87) / 174)
tabnext 1
if exists('s:wipebuf') && len(win_findbuf(s:wipebuf)) == 0 && getbufvar(s:wipebuf, '&buftype') isnot# 'terminal'
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20
let &shortmess = s:shortmess_save
let &winminheight = s:save_winminheight
let &winminwidth = s:save_winminwidth
let s:sx = expand("<sfile>:p:r")."x.vim"
if filereadable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &g:so = s:so_save | let &g:siso = s:siso_save
set hlsearch
nohlsearch
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
