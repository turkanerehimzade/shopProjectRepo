package org.example.models;

import java.io.IOException;

public interface Shop  {
  void create() throws IOException, ClassNotFoundException;
  void delete(String s) throws IOException, ClassNotFoundException;
   void sell(String unikalNomre) throws IOException, ClassNotFoundException;
}
