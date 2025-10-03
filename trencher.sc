__config() -> {'scope'->'global'};
__command() -> 'Run \'/trench info\' for more info about this command.\nA clean GUI is going to replace the commands soon';


spaw(X, Y, Z, NAME, COUNT, YAW, PITCH, DIRECTION) -> (
  if(
    DIRECTION=='north' || DIRECTION == 'n',(
      print('north');
      c_for(i=0, i<sum(COUNT+1), i+=1,
        run('player ' + NAME + i + ' spawn at ' + X + ' ' + Y + ' ' + sum(Z - i) + ' facing ' + YAW + ' ' + PITCH);
      );
      return;
    ),
    DIRECTION=='east' || DIRECTION == 'e',(
      print('east');
      c_for(i=0, i<sum(COUNT+1), i+=1,
        run('player ' + NAME + i + ' spawn at ' + sum(X + i) + ' ' + Y + ' ' + Z + ' facing ' + YAW + ' ' + PITCH);
      );
      return;
    ),
    DIRECTION=='south' || DIRECTION == 's',(
      print('south');
      c_for(i=0, i<sum(COUNT+1), i+=1,
        run('player ' + NAME + i + ' spawn at ' + X + ' ' + Y + ' ' + sum(Z + i) + ' facing ' + YAW + ' ' + PITCH);
      );
      return;
    ),
    DIRECTION=='west' || DIRECTION == 'w',(
      print('west');
      c_for(i=0, i<sum(COUNT+1), i+=1,
        run('player ' + NAME + i + ' spawn at ' + sum(X - i) + ' ' + Y + ' ' + Z + ' facing ' + YAW + ' ' + PITCH);
      );
      return;
    ),
    print('else');
  )



);

kill(NAME, COUNT) -> (
  c_for(i=0, i<sum(COUNT+1), i+=1,
  run('player ' + NAME + i + ' kill');
  );
  return;
);

jump(NAME, COUNT) -> (
  c_for(i=0, i<sum(COUNT+1), i+=1,
  run('player ' + NAME + i + ' jump');
  );
  return;
);

move(NAME, COUNT) -> (
  c_for(i=0, i<sum(COUNT+1), i+=1,
  run('player ' + NAME + i + ' move forward');
  );
  return;
);

stop(NAME, COUNT) -> (
  c_for(i=0, i<sum(COUNT+1), i+=1,
  run('player ' + NAME + i + ' stop');
  );
  return;
);

attack(NAME, COUNT) -> (
  c_for(i=0, i<sum(COUNT+1), i+=1,
  run('player ' + NAME + i + ' attack continuous');
  );
  return;
);

info() -> (
  print(format('qb /trench command'));
  print('');
  print(format('e spaw(X, Y, Z, \'NAME\', COUNT, YAW, PITCH, \'DIRECTION\')'));
  print(format('l kill(\'NAME\', COUNT)'));
  print(format('l jump(\'NAME\', COUNT)'));
  print(format('l move(\'NAME\', COUNT)'));
  print(format('l stop(\'NAME\', COUNT)'));
  print(format('l attack(\'NAME\', COUNT)'));
  print('');
  print(format('eb EXAMPLES:'));
  print(format('l spaw(1, 2, 3, \'goodname\', 5, 90, 45, \'n\')'));
  print(format('e kill(\'anothername\', 7)'));
  print(format('e jump(\'thsd\', 5)'));
  print(format('e move(\'hfasd\', 78)'));
  print(format('e stop(\'sfdgsfg\', 2)'));
  print(format('e attack(\'something\', 8)'));
  print('');
  print(format('c \'spaw\' is intended. the function \'spawn\' is reserved so it cannot be used'));
  print(format('q directions can be either \'north\', \'south\', \'east\', \'west\' or \'n\', \'e\', \'w\', \'s\' etc.'));
  print(format('rb All string values must be inside quotes \'EXAMPLE\''));
  return;
);