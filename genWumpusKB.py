#!/usr/bin/python

def pitSym(x,y):
    return 'P%d%d' % (x,y)

def printKNFEntries(x,y):
    pits = []
    breezeSym = 'B%d%d' % (x,y);
    if x<4:
        pits.append(pitSym(x+1,y))
    if x>1:
        pits.append(pitSym(x-1,y))
    if y<4:
        pits.append(pitSym(x,y+1))
    if y>1:
        pits.append(pitSym(x,y-1))

    # aus Luftzug folgt Falltuere in mind. einem Nachbarfeld
    # ... formuliert in KNF
    print '!%s;%s;' % (breezeSym, ';'.join(pits))

    # aus jedem Pit auf dem Nachbarfeld folgt ein Breeze
    # ... formuliert in KNF
    for p in pits:
        print '!%s;%s;' % (p, breezeSym)

for x in range(1,5):
    for y in range(1,5):
        printKNFEntries(x,y)
