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

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

  private final DataService dataService = new DataServiceImpl();

  @Test
  public void testItem() {
    final String json = "{'data':{'name':'Sample Text','quantity':7},'version':2}";
    final Data<Item> data = dataService.parseItem(json);
    Assert.assertNotNull(data);
    Assert.assertEquals(2, data.getVersion());

    final Item item = data.getData();
    Assert.assertNotNull(item);
    Assert.assertEquals("Sample Text", item.getName());
    Assert.assertEquals(7, item.getQuantity());
  }

  @Test
  public void testPerson() {
    final String json = "{'data':{'name':'Sample Text'},'version':6}";
    final Data<Person> data = dataService.parsePerson(json);
    Assert.assertNotNull(data);
    Assert.assertEquals(6, data.getVersion());

    final Person person = data.getData();
    Assert.assertNotNull(person);
    Assert.assertEquals("Sample Text", person.getName());
  }

}
