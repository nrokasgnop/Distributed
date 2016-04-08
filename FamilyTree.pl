father(taweesak,pairung).
mother(kyo, pairung).
father(taweesak, wichai).
mother(kyo, wichai).
father(taweesak, somsri).
mother(kyo, somsri).

father(pairung, pongsakorn).
mother(nuttee, pongsakorn).
father(pairung, nutthaporn).
mother(nutee, nutthaporn).

father(wichai, kasidet).
mother(kittiwan, kasidet).
father(wichai, sorawit).
mother(kittiwan, sorawit).

father(sorawit, nutthawat).
mother(nutthida, nutthawat).
grandfather(taweesak, X) :- father(taweesak, pairung), father(pairung, X).
grandmother(kyo, X) :- mother(kyo, pairung), father(pairung, X).

brother(pongsakorn, nutthaporn).
sister(nutthaporn, pongsakorn).
brother(kasedit, sorawit).
brother(sorawit, kasedit).

sibling(pongsakorn, X) :- father(wichai, X).
sibling(nutthaporn, X) :- father(wichai, X).
sibling(kasedit, X) :- father(pairung, X).
sibling(sorawit, X) :- father(pairung, X).





