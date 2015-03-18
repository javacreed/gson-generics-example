/*
 * #%L
 * Gson Generics Example
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DataServiceImpl implements DataService {

  private final Gson gson = new GsonBuilder().create();

  // This will not work
  // public <T> Data<T> parseData(final String json) {
  // final Type type = new TypeToken<Data<T>>() {}.getType();
  // return gson.fromJson(json, type);
  // }

  @Override
  public Data<Item> parseItem(final String json) {
    final Type type = new TypeToken<Data<Item>>() {}.getType();
    return gson.fromJson(json, type);
  }

  @Override
  public Data<Person> parsePerson(final String json) {
    final Type type = new TypeToken<Data<Person>>() {}.getType();
    return gson.fromJson(json, type);
  }

}
